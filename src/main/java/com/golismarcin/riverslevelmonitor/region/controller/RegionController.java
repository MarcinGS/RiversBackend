package com.golismarcin.riverslevelmonitor.region.controller;

import com.golismarcin.riverslevelmonitor.common.model.Region;
import com.golismarcin.riverslevelmonitor.region.dto.RegionRiverDto;
import com.golismarcin.riverslevelmonitor.region.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public List<Region> getRegions(){
        return regionService.getRegions();
    }

    @GetMapping("/{name}/rivers")
    public RegionRiverDto getRegionsWithRivers(@PathVariable String name, Pageable pageable){
        return  regionService.getRegionsWithRivers(name, pageable);
    }
}
