package com.golismarcin.riverslevelmonitor.admin.region.controller;

import com.golismarcin.riverslevelmonitor.admin.region.controller.dto.AdminRegionDto;
import com.golismarcin.riverslevelmonitor.admin.region.model.AdminRegion;
import com.golismarcin.riverslevelmonitor.admin.region.service.AdminRegionService;
import com.golismarcin.riverslevelmonitor.common.model.RiverRegion;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/regions")
@RequiredArgsConstructor
public class AdminRegionController {

    private static final Long EMPTY_ID = null;
    private final AdminRegionService adminRegionService;

    @GetMapping
    public List<AdminRegion> getRegions(){
        return adminRegionService.getRegions();
    }

    @GetMapping("/{id}")
    public AdminRegion getRegion(@PathVariable Long id){
        return adminRegionService.getRegion(id);
    }

    @PostMapping
    public AdminRegion createRegion(@RequestBody AdminRegionDto adminRegionDto){
        return adminRegionService.createRegion(mapToAdminRegion(EMPTY_ID, adminRegionDto));
    }


    @PutMapping("/{id}")
    public AdminRegion updateRegion(@PathVariable Long id, @RequestBody AdminRegionDto adminRegionDto){
        return adminRegionService.updateRegion(mapToAdminRegion(id,adminRegionDto));
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id){
        adminRegionService.deleteRegion(id);
    }

    private AdminRegion mapToAdminRegion(Long id, AdminRegionDto adminRegionDto) {
       return AdminRegion.builder()
               .id(id)
                .name(RiverRegion.valueOf(adminRegionDto.getName().replace("-", "_").toUpperCase()))
                .build();
    }

}
