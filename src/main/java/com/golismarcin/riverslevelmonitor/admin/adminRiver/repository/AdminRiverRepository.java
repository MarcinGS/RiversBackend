package com.golismarcin.riverslevelmonitor.admin.adminRiver.repository;

import com.golismarcin.riverslevelmonitor.admin.adminRiver.model.AdminRiver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRiverRepository extends JpaRepository<AdminRiver, Long> {
    Page<AdminRiver> findByRegionId(Long id, Pageable page);
}
