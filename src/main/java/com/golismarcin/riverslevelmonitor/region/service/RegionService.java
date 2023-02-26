package com.golismarcin.riverslevelmonitor.region.service;

import com.golismarcin.riverslevelmonitor.common.dto.UserRiverListDto;
import com.golismarcin.riverslevelmonitor.common.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.common.model.Region;
import com.golismarcin.riverslevelmonitor.common.model.RegionRepository;
import com.golismarcin.riverslevelmonitor.common.model.RiverRegion;
import com.golismarcin.riverslevelmonitor.common.repository.AdminRiverRepository;
import com.golismarcin.riverslevelmonitor.region.dto.RegionRiverDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;
    private final AdminRiverRepository adminRiverRepository;

    public List<Region> getRegions(){
        return regionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RegionRiverDto getRegionsWithRivers(String regionName, Pageable pageable) {
        RiverRegion riverRegion = RiverRegion.valueOf(regionName.replace("-", "_").toUpperCase());
        Region region = regionRepository.findByName(riverRegion);
        Page<AdminRiver> page = adminRiverRepository.findByRegionId(region.getId(), pageable);
        List<UserRiverListDto> userRiverListDtos = page.getContent().stream().map(river -> UserRiverListDto.builder()
                .id(river.getId())
                .stationId(river.getStationId())
                .stationName(river.getStationName())
                .riverName(river.getRiverName())
                .regionId(river.getRegion().getId())
                .waterLevel(river.getMeasurements().get(river.getMeasurements().size()-1).getWaterLevel())
                .waterDate(river.getMeasurements().get(river.getMeasurements().size()-1).getWaterDate())
                .waterTemp(river.getMeasurements().get(river.getMeasurements().size()-1).getWaterTemp())
                .tempDate(river.getMeasurements().get(river.getMeasurements().size()-1).getTempDate())
                .iceLevel(river.getMeasurements().get(river.getMeasurements().size()-1).getIceLevel())
                .iceDate(river.getMeasurements().get(river.getMeasurements().size()-1).getIceDate())
                .growLevel(river.getMeasurements().get(river.getMeasurements().size()-1).getGrowLevel())
                .growDate(river.getMeasurements().get(river.getMeasurements().size()-1).getGrowDate())
                .image(river.getImage())
                .build()).toList();
        return new RegionRiverDto(region,new PageImpl<>(userRiverListDtos, pageable, page.getTotalElements()));
    }
}
