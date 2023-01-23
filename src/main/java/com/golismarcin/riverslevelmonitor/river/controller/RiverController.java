package com.golismarcin.riverslevelmonitor.river.controller;

import com.golismarcin.riverslevelmonitor.river.model.River;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiverController {

    @GetMapping("/rivers")
    public List<River> getRivers(){
        return List.of(
                new River("Rzeka1", "nazwa1", "nazwa", "region","poziom","data",
                        "tempe","data", "poziomL","dataL","poziomG","dataG"),
                new River("Rzeka1", "nazwa1", "nazwa", "region","poziom","data",
                        "tempe","data", "poziomL","dataL","poziomG","dataG"),
                new River("Rzeka1", "nazwa1", "nazwa", "region","poziom","data",
                        "tempe","data", "poziomL","dataL","poziomG","dataG")
        );
    }
}
