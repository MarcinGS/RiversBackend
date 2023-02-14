package com.golismarcin.riverslevelmonitor.admin.adminRiver.controller;

import com.golismarcin.riverslevelmonitor.admin.adminRiver.controller.dto.AdminRiverDto;
import com.golismarcin.riverslevelmonitor.admin.adminRiver.controller.dto.UploadResponse;
import com.golismarcin.riverslevelmonitor.admin.adminRiver.model.AdminRiver;
import com.golismarcin.riverslevelmonitor.admin.adminRiver.service.AdminRiverImageService;
import com.golismarcin.riverslevelmonitor.admin.adminRiver.service.AdminRiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequiredArgsConstructor
public class AdminRiverController {

    public static final Long EMPTY_ID = null;
    private final AdminRiverService adminRiverService;
    private final AdminRiverImageService riverImageService;

    @GetMapping("/admin/rivers")
    public Page<AdminRiver> getRivers(Pageable pageable){
        return adminRiverService.getRivers(pageable);
    }

    @GetMapping("/admin/rivers/{id}")
    public AdminRiver getRiver(@PathVariable Long id){
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

    private static AdminRiver mapAdminRiver(AdminRiverDto adminRiverDto, Long id) {
        return AdminRiver.builder()
                .id(id)
                .stationId(adminRiverDto.getStationId())
                .stationName(adminRiverDto.getStationName())
                .riverName(adminRiverDto.getRiverName())
                .regionId(adminRiverDto.getRegionId())
                .waterLevel(adminRiverDto.getWaterLevel())
                .waterDate(adminRiverDto.getWaterDate())
                .waterTemp(adminRiverDto.getWaterTemp())
                .tempDate(adminRiverDto.getTempDate())
                .iceLevel(adminRiverDto.getIceLevel())
                .iceDate(adminRiverDto.getIceDate())
                .growLevel(adminRiverDto.getGrowLevel())
                .growDate(adminRiverDto.getGrowDate())
                .image(adminRiverDto.getImage())
                .build();
    }
}
