package com.golismarcin.riverslevelmonitor.mapper;

import com.golismarcin.riverslevelmonitor.admin.adminRiver.controller.dto.AdminRiverDto;
import com.golismarcin.riverslevelmonitor.common.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.outerDataProvider.model.RiverMeasurement;
import org.springframework.stereotype.Service;

@Service
public class AdminRiverToDto {
    public static AdminRiverDto mapToAdminRiverDto(AdminRiver adminRiver){
        RiverMeasurement measurement = adminRiver.getMeasurements().get(adminRiver.getMeasurements().size()-1);
        return AdminRiverDto.builder()
                .id(adminRiver.getId())
                .stationId(adminRiver.getStationId())
                .riverName(adminRiver.getRiverName())
                .stationName(adminRiver.getStationName())
                .region(adminRiver.getRegion())
                .iceDate(measurement.getIceDate())
                .iceLevel(measurement.getIceLevel())
                .waterDate(measurement.getWaterDate())
                .waterLevel(measurement.getWaterLevel())
                .growDate(measurement.getGrowDate())
                .growLevel(measurement.getGrowLevel())
                .tempDate(measurement.getTempDate())
                .waterTemp(measurement.getWaterTemp())
                .image(adminRiver.getImage())
                .build();
    }
}
