package com.golismarcin.riverslevelmonitor.userRiver.controller;

import com.golismarcin.riverslevelmonitor.userRiver.model.UserRiver;
import com.golismarcin.riverslevelmonitor.userRiver.service.UserRiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRiverController {

    private final UserRiverService userRiverService;

    @GetMapping("/rivers")
    public Page<UserRiver> getRivers(Pageable pageable){
        return userRiverService.getRivers(pageable);
    }

    @GetMapping("/rivers/{id}")
    public UserRiver getRiver(@PathVariable Long id){
        return userRiverService.getRiver(id);
    }


}
