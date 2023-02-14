package com.golismarcin.riverslevelmonitor.admin.region.controller;

import com.golismarcin.riverslevelmonitor.admin.region.controller.dto.AdminRegionDto;
import com.golismarcin.riverslevelmonitor.admin.region.model.AdminRegion;
import com.golismarcin.riverslevelmonitor.admin.region.service.AdminRegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
                .name(adminRegionDto.getName())
                .build();
    }

}
