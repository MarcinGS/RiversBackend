package com.golismarcin.riverslevelmonitor.userList.controller;

import com.golismarcin.riverslevelmonitor.userList.controller.dto.UserListItemDto;
import com.golismarcin.riverslevelmonitor.userList.model.UserList;
import com.golismarcin.riverslevelmonitor.userList.service.UserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userlist")
@RequiredArgsConstructor
public class UserListController {

    private final UserListService userListService;

    @PutMapping("/{userListId}")
    public UserList addRiverToUserList(@PathVariable Long userListId, @RequestBody UserListItemDto userListItemDto){
       return userListService.addRiverToPrivateList(userListId, userListItemDto);
    }

    @GetMapping("/{userListId}")
    public UserList getUserList(@PathVariable Long userListId){
        return userListService.getUserList(userListId);
    }

    @DeleteMapping("/{userListId}")
    public void deleteRiverFromUserList(@PathVariable Long userListId) {
         userListService.deleteRiverFromUserList(userListId);
    }
}

