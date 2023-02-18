package com.golismarcin.riverslevelmonitor.region.service;

import com.golismarcin.riverslevelmonitor.admin.adminRiver.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.admin.adminRiver.repository.AdminRiverRepository;
import com.golismarcin.riverslevelmonitor.region.model.Region;
import com.golismarcin.riverslevelmonitor.region.model.RegionRiverDto;
import com.golismarcin.riverslevelmonitor.region.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public RegionRiverDto getRegionsWithRivers(String name, Pageable pageable) {
        Region region = regionRepository.findByName(name);
        Page<AdminRiver> page = adminRiverRepository.findByRegionId(region.getId(), pageable);
        return new RegionRiverDto(region,page);
    }
}
