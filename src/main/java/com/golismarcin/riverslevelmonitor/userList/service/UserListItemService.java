package com.golismarcin.riverslevelmonitor.userList.service;

import com.golismarcin.riverslevelmonitor.userList.repository.UserListItemRepository;
import com.golismarcin.riverslevelmonitor.userList.repository.UserListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserListItemService {

    private final UserListItemRepository userListItemRepository;
    private final UserListRepository userListRepository;

    public void deleteRiverFromUserList(Long riverId) {
        userListItemRepository.deleteById(riverId);
    }


    public Long countItemsInUserList(Long userListId) {
        return userListItemRepository.countByUserListId(userListId);
    }
}
