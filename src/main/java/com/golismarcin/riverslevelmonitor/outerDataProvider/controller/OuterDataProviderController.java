package com.golismarcin.riverslevelmonitor.outerDataProvider.controller;

import com.golismarcin.riverslevelmonitor.admin.adminRiver.controller.dto.AdminRiverDto;
import com.golismarcin.riverslevelmonitor.admin.adminRiver.service.AdminRiverService;
import com.golismarcin.riverslevelmonitor.common.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.outerDataProvider.service.OuterDataProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.golismarcin.riverslevelmonitor.mapper.AdminRiverToDto.mapToAdminRiverDto;

@RestController
@RequiredArgsConstructor
public class OuterDataProviderController {

    private final OuterDataProviderService outerDataProviderService;
    private final AdminRiverService adminRiverService;

    @GetMapping("/data")
    public void getData() throws IOException {
        outerDataProviderService.getRiversFromProvider();
    }

    @GetMapping("/rivers")
    public Page<AdminRiverDto> getRivers(Pageable pageable){
        return adminRiverService.getRivers(pageable).map(r -> mapToAdminRiverDto(r));
    }

    @GetMapping("/rivers/site/{id}")
    public AdminRiver getRiverForSite(@PathVariable Long id){
        return adminRiverService.getRiver(id);
    }


}
