package com.golismarcin.riverslevelmonitor.region.repository;

import com.golismarcin.riverslevelmonitor.region.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
