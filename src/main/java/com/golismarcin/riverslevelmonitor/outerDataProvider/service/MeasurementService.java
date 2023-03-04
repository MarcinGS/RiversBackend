package com.golismarcin.riverslevelmonitor.outerDataProvider.service;

import com.golismarcin.riverslevelmonitor.outerDataProvider.model.RiverMeasurement;
import com.golismarcin.riverslevelmonitor.outerDataProvider.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    public Page<RiverMeasurement> getRiverMeasurement(Pageable pageable, Long riverId) {
        return measurementRepository.findByRiverId(pageable, riverId);
    }
}
