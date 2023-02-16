package com.golismarcin.riverslevelmonitor.region.service;

import com.golismarcin.riverslevelmonitor.region.model.Region;
import com.golismarcin.riverslevelmonitor.region.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getRegions(){
        return regionRepository.findAll();
    }
}
