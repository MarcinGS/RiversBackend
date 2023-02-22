package com.golismarcin.riverslevelmonitor.userList.controller;

import com.golismarcin.riverslevelmonitor.userList.service.UserListItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userListItems")
@RequiredArgsConstructor
public class UserListItemController {

    private final UserListItemService userListItemService;

    @DeleteMapping("/{id}")
    public void deleteRiverFromUserList(@PathVariable Long id) {
        userListItemService.deleteRiverFromUserList(id);
    }

    @GetMapping("/count/{userListId}")
    public Long countItemsInUserList(@PathVariable Long userListId){
        return userListItemService.countItemsInUserList(userListId);
    }
}
