package com.golismarcin.riverslevelmonitor.region.repository;

import com.golismarcin.riverslevelmonitor.common.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByName(String name);
}
