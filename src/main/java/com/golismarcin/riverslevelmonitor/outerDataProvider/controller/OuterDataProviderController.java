package com.golismarcin.riverslevelmonitor.outerDataProvider.controller;

import com.golismarcin.riverslevelmonitor.outerDataProvider.service.OuterDataProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class OuterDataProviderController {

    private final OuterDataProviderService outerDataProviderService;

    @GetMapping("/data")
    public void getData() throws IOException {
        outerDataProviderService.getRiversFromProvider();
    }
}
