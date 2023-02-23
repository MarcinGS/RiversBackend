package com.golismarcin.riverslevelmonitor.admin.outerDataProvider.model.controller;

import com.golismarcin.riverslevelmonitor.admin.outerDataProvider.service.OuterDataProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class OuterDataProviderController {

    private final OuterDataProviderService outerDataProviderService;


    @GetMapping("/data")
    public ResponseEntity<String> getData() throws IOException {
        outerDataProviderService.getRiversFromProvider();
        return ResponseEntity.status(HttpStatus.OK).body("dane pobrane");
    }
}
