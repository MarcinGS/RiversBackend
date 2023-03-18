package com.golismarcin.riverslevelmonitor.outerDataProvider.service;

import com.golismarcin.riverslevelmonitor.outerDataProvider.model.RiverMeasurement;
import com.golismarcin.riverslevelmonitor.outerDataProvider.model.dto.StatisticsDto;
import com.golismarcin.riverslevelmonitor.outerDataProvider.repository.MeasurementRepository;
import com.golismarcin.riverslevelmonitor.outerDataProvider.repository.OuterDataProviderRepository;
import com.golismarcin.riverslevelmonitor.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private  final UserRepository userRepository;
    private final OuterDataProviderRepository outerDataProviderRepository;

    public Page<RiverMeasurement> getRiverMeasurement(Pageable pageable, Long riverId) {
        return measurementRepository.findByRiverId(pageable, riverId);
    }

    public List<RiverMeasurement> getRiverMeasurementTab(Long riverId) {
        return  measurementRepository.findByRiverId(riverId);
    }

    public StatisticsDto getStatistics() {
        Long measurementCount =  measurementRepository.count();
        Long userCount = userRepository.count();
        Long riverCount = outerDataProviderRepository.count();
        return new StatisticsDto(measurementCount, userCount, riverCount);
    }
}
