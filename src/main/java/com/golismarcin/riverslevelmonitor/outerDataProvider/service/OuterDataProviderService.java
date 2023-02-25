package com.golismarcin.riverslevelmonitor.outerDataProvider.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.golismarcin.riverslevelmonitor.common.model.Region;
import com.golismarcin.riverslevelmonitor.common.model.RegionRepository;
import com.golismarcin.riverslevelmonitor.common.model.RiverRegion;
import com.golismarcin.riverslevelmonitor.outerDataProvider.model.River;
import com.golismarcin.riverslevelmonitor.outerDataProvider.model.RiverMeasurement;
import com.golismarcin.riverslevelmonitor.outerDataProvider.model.dto.RiverDto;
import com.golismarcin.riverslevelmonitor.outerDataProvider.repository.OuterDataProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor
public class OuterDataProviderService {

    private final OuterDataProviderRepository outerDataProviderRepository;
    private final RegionRepository regionRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Value("${outerData.downUrl}")
    private String imgwUrl;

    @Transactional
    public void getRiversFromProvider() throws IOException {
        List<RiverDto> riverDto = new ObjectMapper().readValue(new URL(imgwUrl), new TypeReference<List<RiverDto>>() {});
        List<River> outerRivers =  riverDto.stream().map(this::mapDtoToRiver).toList();
        List<River> riversToSave = getChangedRivers(outerRivers);
        outerDataProviderRepository.saveAll(riversToSave);
    }

    private List<River> getChangedRivers(List<River> outerRivers) {
        List<River> dbRivers = outerDataProviderRepository.findAll();
        //gdy pusta baza
        if(dbRivers.size() == 0){
            dbRivers.addAll(outerRivers);
            return dbRivers;
        }

        //tworzy porównuje i dodaje pomiary do rzek
        List<River> riversToSave = new ArrayList<>();
        for (River outerRiv : outerRivers) {
            for (River dbRiv : dbRivers) {
                if(outerRiv.getStationId().longValue() == dbRiv.getStationId().longValue()){
                    if(!dbRiv.getMeasurements().get(dbRiv.getMeasurements().size()-1).equals(outerRiv.getMeasurements().get(0))) {
                        System.out.println(dbRiv.getId());
                        dbRiv.addMeasurements(outerRiv.getMeasurements().get(0));
                        riversToSave.add(dbRiv);
                    }
                }
            }
        }
        return riversToSave;
    }

    private River mapDtoToRiver(RiverDto riverDto){
        River river = mapToRiver(riverDto);
        river.addMeasurements(mapToRiverMeasurement(riverDto));
        return river;
    }

    private River mapToRiver(RiverDto riverDto){
        return River.builder()
                .riverName(riverDto.rzeka)
                .stationName(riverDto.stacja)
                .stationId(Long.parseLong(riverDto.id_stacji))
                .region(parseRegionName(riverDto.województwo))
                .build();
    }

    private Region parseRegionName(String regionName) {
        if (regionName != null && regionName.length() > 5) {
            RiverRegion riverRegion = RiverRegion.valueOf(regionName.replace("-", "_").toUpperCase());
           Region region = regionRepository.findByName(riverRegion);
            return region;
        }else
            return null;
    }

    private RiverMeasurement mapToRiverMeasurement(RiverDto riverDto){
        return RiverMeasurement.builder()
                .iceLevel(ifNullDouble(riverDto.zjawisko_lodowe))
                .iceDate(ifNullDate(riverDto.zjawisko_lodowe_data_pomiaru))
                .growLevel(ifNullDouble(riverDto.zjawisko_zarastania))
                .growDate(ifNullDate(riverDto.zjawisko_zarastania_data_pomiaru))
                .waterTemp(ifNullDouble(riverDto.temperatura_wody))
                .tempDate(ifNullDate(riverDto.temperatura_wody_data_pomiaru))
                .waterLevel(ifNullDouble(riverDto.stan_wody))
                .waterDate(ifNullDate(riverDto.stan_wody_data_pomiaru))
                .build();
    }

    private LocalDateTime ifNullDate(String value){
        if(value == null){
            return null;
        }else{
            return LocalDateTime.parse(value, dateTimeFormatter);
        }
    }

    private Double ifNullDouble(String value){
        if(value == null){
            return null;
        }else{
            return Double.valueOf(value);
        }
    }
}
