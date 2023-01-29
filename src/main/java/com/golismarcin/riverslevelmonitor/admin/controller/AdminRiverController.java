package com.golismarcin.riverslevelmonitor.admin.controller;

import com.golismarcin.riverslevelmonitor.admin.dto.AdminRiverDto;
import com.golismarcin.riverslevelmonitor.admin.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.admin.service.AdminRiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminRiverController {

    public static final Long EMPTY_ID = null;
    private final AdminRiverService adminRiverService;

    @GetMapping("/admin/rivers")
    public Page<AdminRiver> getRivers(Pageable pageable){
        return adminRiverService.getRivers(pageable);
    }

    @GetMapping("/admin/rivers/{id}")
    public AdminRiver getRiver(@PathVariable Long id){
        return adminRiverService.getRiver(id);
    }

    @PostMapping("/admin/rivers")
    public AdminRiver createRiver(@RequestBody AdminRiverDto adminRiverDto){
        return adminRiverService.createRiver(mapAdminRiver(adminRiverDto, EMPTY_ID));
   }

    @PutMapping("/admin/rivers/{id}")
    public AdminRiver updateRiver(@RequestBody AdminRiverDto adminRiverDto, @PathVariable Long id){
        return adminRiverService.updateRiver(mapAdminRiver(adminRiverDto, id));
    }

    private static AdminRiver mapAdminRiver(AdminRiverDto adminRiverDto, Long id) {
        return AdminRiver.builder()
                .id(id)
                .stationId(adminRiverDto.getStationId())
                .stationName(adminRiverDto.getStationName())
                .riverName(adminRiverDto.getRiverName())
                .region(adminRiverDto.getRegion())
                .waterLevel(adminRiverDto.getWaterLevel())
                .waterDate(adminRiverDto.getWaterDate())
                .waterTemp(adminRiverDto.getWaterTemp())
                .tempDate(adminRiverDto.getTempDate())
                .iceLevel(adminRiverDto.getIceLevel())
                .iceDate(adminRiverDto.getIceDate())
                .growLevel(adminRiverDto.getGrowLevel())
                .growDate(adminRiverDto.getGrowDate())
                .build();
    }
}
