package com.golismarcin.riverslevelmonitor.admin.adminRiver.controller.dto;

import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class AdminRiverDto {
        @NotNull
        private Long stationId;
        @NotEmpty
        @NotBlank
        private String stationName;
        @NotEmpty
        @NotBlank
        private String riverName;
        @NotNull
        private Long regionId;
        private Double waterLevel;
        private LocalDateTime waterDate;
        private Double waterTemp;
        private LocalDateTime  tempDate;
        @Min(0)
        private Double iceLevel;
        private LocalDateTime  iceDate;
        @Min(0)
        private Double growLevel;
        private LocalDateTime growDate;
        private String image;
}
