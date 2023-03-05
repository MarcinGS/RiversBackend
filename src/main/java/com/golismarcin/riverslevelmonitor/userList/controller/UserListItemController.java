package com.golismarcin.riverslevelmonitor.userList.controller;

import com.golismarcin.riverslevelmonitor.userList.service.UserListItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userlistitems")
@RequiredArgsConstructor
public class UserListItemController {

    private final UserListItemService userListItemService;

    @DeleteMapping("/{id}")
    public void deleteRiverFromUserList(@PathVariable Long id) {
        userListItemService.deleteRiverFromUserList(id);
    }

    @GetMapping("/count")
    public Long countItemsInUserList(@AuthenticationPrincipal Long userId){
        return userListItemService.countItemsInUserList(userId);
    }
}
