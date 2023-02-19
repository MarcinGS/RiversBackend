package com.golismarcin.riverslevelmonitor.userRiver.controller;

import com.golismarcin.riverslevelmonitor.common.dto.UserRiverListDto;
import com.golismarcin.riverslevelmonitor.common.model.UserRiver;
import com.golismarcin.riverslevelmonitor.userRiver.service.UserRiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRiverController {

    private final UserRiverService userRiverService;

    @GetMapping("/rivers")
    public Page<UserRiverListDto> getRivers(Pageable pageable){
        Page<UserRiver> rivers = userRiverService.getRivers(pageable);
        List<UserRiverListDto> userRiverListDtos = rivers.getContent().stream().map(river -> UserRiverListDto.builder()
                .id(river.getId())
                .stationId(river.getStationId())
                .stationName(river.getStationName())
                .riverName(river.getRiverName())
                .regionId(river.getRegionId())
                .waterLevel(river.getWaterLevel())
                .waterDate(river.getWaterDate())
                .waterTemp(river.getWaterTemp())
                .tempDate(river.getTempDate())
                .iceLevel(river.getIceLevel())
                .iceDate(river.getIceDate())
                .growLevel(river.getGrowLevel())
                .growDate(river.getGrowDate())
                .image(river.getImage())
                .build()).toList();
        return new PageImpl<>(userRiverListDtos, pageable, rivers.getTotalElements());
    }

    @GetMapping("/rivers/{stationId}")
    public UserRiver getRiver(@PathVariable Long stationId){
        return userRiverService.getRiver(stationId);
    }


}
