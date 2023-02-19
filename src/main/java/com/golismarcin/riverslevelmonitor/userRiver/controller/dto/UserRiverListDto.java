package com.golismarcin.riverslevelmonitor.userRiver.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserRiverListDto {
    private Long id;
    private Long stationId;
    private String stationName;
    private String riverName;
    private Long regionId;
    private Double waterLevel;
    private LocalDateTime waterDate;
    private Double waterTemp;
    private LocalDateTime  tempDate;
    private Double iceLevel;
    private LocalDateTime  iceDate;
    private Double growLevel;
    private LocalDateTime growDate;
    private String image;
}
