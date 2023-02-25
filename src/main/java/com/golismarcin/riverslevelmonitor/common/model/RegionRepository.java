package com.golismarcin.riverslevelmonitor.common.model;


import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends  JpaRepository<Region, Long> {

    Region findByName(RiverRegion name);
}
