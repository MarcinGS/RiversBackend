package com.golismarcin.riverslevelmonitor.admin.adminRiver.service;

import com.golismarcin.riverslevelmonitor.admin.adminRiver.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.common.repository.AdminRiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminRiverService {

    private final AdminRiverRepository adminRiverRepository;

    public Page<AdminRiver> getRivers(Pageable pageable){
        return adminRiverRepository.findAll(pageable);
    }

    public AdminRiver getRiver(Long id) {
        return adminRiverRepository.findById(id).orElseThrow();
    }

    public AdminRiver createRiver(AdminRiver river) {
        return adminRiverRepository.save(river);
    }

    public AdminRiver updateRiver(AdminRiver river) {
        return adminRiverRepository.save(river);
    }

    public void deleteRiver(Long id) {
        adminRiverRepository.deleteById(id);
    }
}
