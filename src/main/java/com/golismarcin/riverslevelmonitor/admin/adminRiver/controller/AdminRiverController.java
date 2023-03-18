package com.golismarcin.riverslevelmonitor.admin.adminRiver.controller;

import com.golismarcin.riverslevelmonitor.admin.adminRiver.controller.dto.AdminRiverDto;
import com.golismarcin.riverslevelmonitor.admin.adminRiver.controller.dto.UploadResponse;
import com.golismarcin.riverslevelmonitor.admin.adminRiver.service.AdminRiverImageService;
import com.golismarcin.riverslevelmonitor.admin.adminRiver.service.AdminRiverService;
import com.golismarcin.riverslevelmonitor.common.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.outerDataProvider.model.RiverMeasurement;
import com.golismarcin.riverslevelmonitor.outerDataProvider.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.golismarcin.riverslevelmonitor.mapper.AdminRiverToDto.mapToAdminRiverDto;

@RestController
@RequiredArgsConstructor
public class AdminRiverController {

    public static final Long EMPTY_ID = null;
    private final AdminRiverService adminRiverService;
    private final AdminRiverImageService riverImageService;
    private final MeasurementService measurementService;

    @GetMapping("/admin/rivers")
    public Page<AdminRiverDto> getRivers(Pageable pageable){
        return adminRiverService.getRivers(pageable).map(r -> mapToAdminRiverDto(r));
    }

    @GetMapping("/admin/rivers/{id}")
    public AdminRiverDto getRiverForAdmin(@PathVariable Long id){
        return mapToAdminRiverDto(adminRiverService.getRiver(id));
    }

    @GetMapping("/admin/rivers/site/{id}")
    public AdminRiver getRiverForSite(@PathVariable Long id){
        return adminRiverService.getRiver(id);
    }

    @PostMapping("/admin/rivers")
    public AdminRiver createRiver(@RequestBody @Valid AdminRiverDto adminRiverDto){
        return adminRiverService.createRiver(mapAdminRiver(adminRiverDto, EMPTY_ID));
   }

    @PutMapping("/admin/rivers/{id}")
    public AdminRiver updateRiver(@RequestBody @Valid AdminRiverDto adminRiverDto, @PathVariable Long id){
        return adminRiverService.updateRiver(mapAdminRiver(adminRiverDto, id));
    }

    @DeleteMapping("/admin/rivers/{id}")
    public void deleteRiver(@PathVariable Long id){
        adminRiverService.deleteRiver(id);
    }

    @PostMapping("/admin/rivers/upload-image")
    public UploadResponse uploadImage(@RequestParam("file") MultipartFile multipartFile){
        try(InputStream inputStream = multipartFile.getInputStream()){
            String savedFilename = riverImageService.uploadImage(multipartFile.getOriginalFilename(), inputStream);
            return new UploadResponse(savedFilename);
        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas wgrywania pliku", e);
        }
    }

    @GetMapping("/data/riverImage/{filename}")
    public ResponseEntity<Resource> serveFiles(@PathVariable String filename) throws IOException {
        Resource file = riverImageService.serveFiles(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Path.of(filename)))
                .body(file);
    }


    private AdminRiver mapAdminRiver(AdminRiverDto adminRiverDto, Long id) {
        AdminRiver river =  AdminRiver.builder()
                .id(id)
                .stationId(adminRiverDto.getStationId())
                .stationName(adminRiverDto.getStationName())
                .riverName(adminRiverDto.getRiverName())
                .image(adminRiverDto.getImage())
                .region(adminRiverDto.getRegion())
                .measurements(measurementService.getRiverMeasurementTab(id))
                .build();
                 river.getMeasurements().add(
                         RiverMeasurement.builder()
                        .waterLevel(adminRiverDto.getWaterLevel())
                        .waterDate(adminRiverDto.getWaterDate())
                        .waterTemp(adminRiverDto.getWaterTemp())
                        .tempDate(adminRiverDto.getTempDate())
                        .iceLevel(adminRiverDto.getIceLevel())
                        .iceDate(adminRiverDto.getIceDate())
                        .growLevel(adminRiverDto.getGrowLevel())
                        .growDate(adminRiverDto.getGrowDate())
                        .build());
                 return river;
    }


}
