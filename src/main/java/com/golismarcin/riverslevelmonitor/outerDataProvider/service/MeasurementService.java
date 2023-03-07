package com.golismarcin.riverslevelmonitor.outerDataProvider.service;

import com.golismarcin.riverslevelmonitor.outerDataProvider.model.RiverMeasurement;
import com.golismarcin.riverslevelmonitor.outerDataProvider.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    public Page<RiverMeasurement> getRiverMeasurement(Pageable pageable, Long riverId) {
        return measurementRepository.findByRiverId(pageable, riverId);
    }

    public List<RiverMeasurement> getRiverMeasurementTab(Long riverId) {
        return  measurementRepository.findByRiverId(riverId);
    }
}
