package com.golismarcin.riverslevelmonitor.admin.adminRiver.controller.dto;

import com.golismarcin.riverslevelmonitor.common.model.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminRiverDto {
        private Long id;
        @NotNull
        private Long stationId;
        @NotEmpty
        @NotBlank
        private String stationName;
        @NotEmpty
        @NotBlank
        private String riverName;
        @NotNull
        private Region region;
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
