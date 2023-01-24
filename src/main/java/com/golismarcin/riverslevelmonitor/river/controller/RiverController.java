package com.golismarcin.riverslevelmonitor.river.controller;

import com.golismarcin.riverslevelmonitor.river.model.River;
import com.golismarcin.riverslevelmonitor.river.service.RiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RiverController {

    private final RiverService riverService;

    @GetMapping("/rivers")
    public List<River> getRivers(){
        return riverService.getRivers();
    }
}
