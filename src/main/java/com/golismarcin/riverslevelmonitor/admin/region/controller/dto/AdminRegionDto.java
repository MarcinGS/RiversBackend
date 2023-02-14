package com.golismarcin.riverslevelmonitor.admin.region.controller.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class AdminRegionDto {
    @NotBlank
    @NotNull
    private String name;
}
