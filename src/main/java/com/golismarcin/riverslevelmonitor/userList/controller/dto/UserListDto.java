package com.golismarcin.riverslevelmonitor.userList.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListDto {
    private Long id;
    private LocalDateTime created;
    private List<UserListItemDto> items;
}
