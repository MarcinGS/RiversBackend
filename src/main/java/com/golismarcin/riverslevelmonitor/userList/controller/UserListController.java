package com.golismarcin.riverslevelmonitor.userList.controller;


import com.golismarcin.riverslevelmonitor.userList.controller.dto.UserListDto;
import com.golismarcin.riverslevelmonitor.userList.controller.dto.UserListItemDto;
import com.golismarcin.riverslevelmonitor.userList.controller.dto.UserListItemIdDto;
import com.golismarcin.riverslevelmonitor.userList.model.UserList;
import com.golismarcin.riverslevelmonitor.userList.service.UserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.golismarcin.riverslevelmonitor.mapper.AdminRiverToDto.mapToAdminRiverDto;


@RestController
@RequestMapping("/userlist")
@RequiredArgsConstructor
public class UserListController {

    private final UserListService userListService;

    @PutMapping("/{userListId}")
    public UserList addRiverToUserList(@PathVariable Long userListId, @RequestBody UserListItemIdDto userListItemIdDto){
       return userListService.addRiverToUserList(userListId, userListItemIdDto);
    }

    @GetMapping("/{userListId}")
    public UserListDto getUserList(@PathVariable Long userListId){
        UserList userList = userListService.getUserList(userListId);

        return UserListDto.builder()
                .id(userList.getId())
                .created(userList.getCreated())
                .items(userList.getItems().stream().map(e -> UserListItemDto.builder()
                        .id(e.getId())
                        .userListId(e.getUserListId())
                        .river(mapToAdminRiverDto(e.getRiver()))
                        .build()).toList()).build();

    }




}

