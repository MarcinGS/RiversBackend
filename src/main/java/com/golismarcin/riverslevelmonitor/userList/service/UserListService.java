package com.golismarcin.riverslevelmonitor.userList.service;

import com.golismarcin.riverslevelmonitor.common.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.common.repository.AdminRiverRepository;
import com.golismarcin.riverslevelmonitor.userList.controller.dto.UserListItemDto;
import com.golismarcin.riverslevelmonitor.userList.model.UserList;
import com.golismarcin.riverslevelmonitor.userList.model.UserListItem;
import com.golismarcin.riverslevelmonitor.userList.repository.UserListItemRepository;
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
    private final UserListItemRepository userListItemRepository;

    public UserList getUserList(Long id) {
        return userListRepository.findById(id).orElseThrow();
    }

    @Transactional
    public UserList addRiverToPrivateList(Long userListId, UserListItemDto userListItemDto) {
        UserList userList = getInitializedUserList(userListId);
        System.out.println("List: " + userList);
        userList.addRiver(UserListItem.builder()
                .river(getAdminRiver(userListItemDto.riverId()))
                .build());
        return userList;
    }

    private AdminRiver getAdminRiver(Long riverId) {
        System.out.println("riverId get " + riverId);
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


    public void deleteRiverFromUserList(Long riverId) {
       userListItemRepository.deleteById(riverId);
    }
}
