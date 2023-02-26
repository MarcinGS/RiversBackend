package com.golismarcin.riverslevelmonitor.userList.service;

import com.golismarcin.riverslevelmonitor.common.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.common.repository.AdminRiverRepository;
import com.golismarcin.riverslevelmonitor.userList.controller.dto.UserListItemIdDto;
import com.golismarcin.riverslevelmonitor.userList.model.UserList;
import com.golismarcin.riverslevelmonitor.userList.model.UserListItem;
import com.golismarcin.riverslevelmonitor.userList.repository.UserListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserListService {

    private final UserListRepository userListRepository;
    private final AdminRiverRepository adminRiverRepository;

    public UserList getUserList(Long id) {
        return userListRepository.findById(id).orElseThrow();
    }

    @Transactional
    public UserList addRiverToUserList(Long userListId, UserListItemIdDto userListItemIdDto) {
        UserList userList = getInitializedUserList(userListId);
        userList.addRiver(UserListItem.builder()
                .river(getAdminRiver(userListItemIdDto.riverId()))
                .build());
        return userList;
    }

    private AdminRiver getAdminRiver(Long riverId) {
        return adminRiverRepository.findById(riverId).orElseThrow();
    }

    private UserList getInitializedUserList(Long id) {
        if (id == null || id <= 0) {
            return userListRepository.save(UserList.builder()
                    .created(LocalDateTime.now())
                    .build());
        }
        return userListRepository.findById(id).orElseThrow();
    }

}
