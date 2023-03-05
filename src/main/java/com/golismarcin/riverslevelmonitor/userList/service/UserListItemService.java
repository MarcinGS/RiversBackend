package com.golismarcin.riverslevelmonitor.userList.service;

import com.golismarcin.riverslevelmonitor.userList.model.UserList;
import com.golismarcin.riverslevelmonitor.userList.repository.UserListItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserListItemService {

    private final UserListItemRepository userListItemRepository;
    private final UserListService userListService;

    public void deleteRiverFromUserList(Long riverId) {
        userListItemRepository.deleteById(riverId);
    }

    public Long countItemsInUserList(Long userId) {
        UserList userList = userListService.getUserList(userId);
        return userListItemRepository.countByUserListId(userList.getId());
    }
}
