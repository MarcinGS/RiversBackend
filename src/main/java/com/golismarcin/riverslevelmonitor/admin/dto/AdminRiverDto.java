package com.golismarcin.riverslevelmonitor.admin.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AdminRiverDto {
        private String stationId;
        private String stationName;
        private String riverName;
        private String region;
        private Double waterLevel;
        private LocalDateTime waterDate;
        private Double waterTemp;
        private LocalDateTime  tempDate;
        private Double iceLevel;
        private LocalDateTime  iceDate;
        private Double growLevel;
        private LocalDateTime growDate;
}
