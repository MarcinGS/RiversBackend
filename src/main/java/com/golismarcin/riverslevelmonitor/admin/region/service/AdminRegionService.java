package com.golismarcin.riverslevelmonitor.admin.region.service;

import com.golismarcin.riverslevelmonitor.admin.region.model.AdminRegion;
import com.golismarcin.riverslevelmonitor.admin.region.repository.AdminRegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminRegionService {
    private final AdminRegionRepository adminRegionRepository;

    public List<AdminRegion> getRegions() {
        return adminRegionRepository.findAll();
    }

    public AdminRegion getRegion(Long id) {
        return adminRegionRepository.findById(id).orElseThrow();
    }

    public AdminRegion createRegion(AdminRegion adminRegion) {
        return adminRegionRepository.save(adminRegion);
    }

    public AdminRegion updateRegion(AdminRegion adminRegion) {
        return adminRegionRepository.save(adminRegion);
    }

    public void deleteRegion(Long id) {
        adminRegionRepository.deleteById(id);
    }
}
