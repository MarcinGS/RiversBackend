package com.golismarcin.riverslevelmonitor.admin.outerDataProvider.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.golismarcin.riverslevelmonitor.admin.outerDataProvider.model.River;
import com.golismarcin.riverslevelmonitor.admin.outerDataProvider.model.RiverMeasurement;
import com.golismarcin.riverslevelmonitor.admin.outerDataProvider.model.dto.RiverDto;
import com.golismarcin.riverslevelmonitor.admin.outerDataProvider.model.repository.OuterDataProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OuterDataProviderService {

    private final OuterDataProviderRepository outerDataProviderRepository;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Value("${outerData.downUrl}")
    private String imgwUrl;

    @Transactional
    public void getRiversFromProvider() throws IOException {
        List<RiverDto> riverDto = new ObjectMapper().readValue(new URL("https://danepubliczne.imgw.pl/api/data/hydro/format/json"), new TypeReference<List<RiverDto>>() {});
           List<River> rivers =  riverDto.stream().map(this::mapDto).toList();
           outerDataProviderRepository.saveAll(rivers);
    }

    private River mapDto(RiverDto riverDto){
        River river = mapToRiver(riverDto);
        river.addMeasurements(mapToRiverMeasurement(riverDto));
        return river;
    }

    private River mapToRiver(RiverDto riverDto){
        return River.builder()
                .riverName(riverDto.rzeka)
                .stationName(riverDto.stacja)
                .stationId(Long.parseLong(riverDto.id_stacji))
                .build();
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
