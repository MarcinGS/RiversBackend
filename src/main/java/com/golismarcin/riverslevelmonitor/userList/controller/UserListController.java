package com.golismarcin.riverslevelmonitor.userList.controller;


import com.golismarcin.riverslevelmonitor.userList.controller.dto.UserListDto;
import com.golismarcin.riverslevelmonitor.userList.controller.dto.UserListItemDto;
import com.golismarcin.riverslevelmonitor.userList.controller.dto.UserListItemIdDto;
import com.golismarcin.riverslevelmonitor.userList.model.UserList;
import com.golismarcin.riverslevelmonitor.userList.service.UserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PutMapping()
    public UserListDto addRiverToUserList(@RequestBody UserListItemIdDto userListItemIdDto,
                                       @AuthenticationPrincipal Long userId){
        UserList userList = userListService.addRiverToUserList(userListItemIdDto, userId);
        return mapToUserListDto(userList);
    }

    @GetMapping()
    public UserListDto getUserList(@AuthenticationPrincipal Long userId){
        UserList userList = userListService.getUserList(userId);

        return mapToUserListDto(userList);

    }

    private static UserListDto mapToUserListDto(UserList userList) {
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

