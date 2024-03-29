package com.golismarcin.riverslevelmonitor.userList.controller.dto;

import com.golismarcin.riverslevelmonitor.admin.adminRiver.controller.dto.AdminRiverDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListItemDto {
    private Long id;
    private Long userListId;
    private AdminRiverDto river;
}
