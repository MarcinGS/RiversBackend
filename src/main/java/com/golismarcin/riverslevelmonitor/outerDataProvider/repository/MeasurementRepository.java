package com.golismarcin.riverslevelmonitor.outerDataProvider.repository;

import com.golismarcin.riverslevelmonitor.outerDataProvider.model.RiverMeasurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<RiverMeasurement, Long> {

    Page<RiverMeasurement> findByRiverId(Pageable pageable, Long riverId);
}
