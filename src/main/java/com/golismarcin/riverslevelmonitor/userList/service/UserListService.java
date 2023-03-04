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

    public UserList getUserList(Long userId) {
        return userListRepository.findByUserId(userId);
    }

    @Transactional
    public UserList addRiverToUserList(UserListItemIdDto userListItemIdDto, Long userId) {
        UserList userList = getInitializedUserList(userId);
        userList.addRiver(UserListItem.builder()
                .river(getAdminRiver(userListItemIdDto.riverId()))
                .build());
        return userList;
    }

    public UserList createNewUserList(Long userId){
        return userListRepository.save(UserList.builder()
                .created(LocalDateTime.now())
                .userId(userId)
                .build());
    }

    private AdminRiver getAdminRiver(Long riverId) {
        return adminRiverRepository.findById(riverId).orElseThrow();
    }

    private UserList getInitializedUserList(Long userId) {
        if (userId == null || userId <= 0) {
            return userListRepository.save(UserList.builder()
                    .created(LocalDateTime.now())
                    .userId(userId)
                    .build());
        }
        return userListRepository.findByUserId(userId);
    }

}
