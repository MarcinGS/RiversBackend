package com.golismarcin.riverslevelmonitor.outerDataProvider.controller;

import com.golismarcin.riverslevelmonitor.outerDataProvider.model.RiverMeasurement;
import com.golismarcin.riverslevelmonitor.outerDataProvider.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MeasurementController {

    public final MeasurementService measurementService;

    @GetMapping("/measurement/{riverId}")
    public Page<RiverMeasurement> getRiverMeasurement(@RequestParam int page, @RequestParam int size, @PathVariable Long riverId){
        Pageable pageable = PageRequest.of(page,size);
        return measurementService.getRiverMeasurement(pageable, riverId);
    }
}
