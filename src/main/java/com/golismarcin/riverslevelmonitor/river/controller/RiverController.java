package com.golismarcin.riverslevelmonitor.river.controller;

import com.golismarcin.riverslevelmonitor.river.model.River;
import com.golismarcin.riverslevelmonitor.river.service.RiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RiverController {

    private final RiverService riverService;

    @GetMapping("/rivers")
    public Page<River> getRivers(Pageable pageable){
        return riverService.getRivers(pageable);
    }
}
