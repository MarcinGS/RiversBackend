package com.golismarcin.riverslevelmonitor.river.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class River {
    private String stationId;
    private String stationName;
    private String riverName;
    private String region;
    private String waterLevel;
    private String waterDate;
    private String waterTemp;
    private String tempDate;
    private String iceLevel;
    private String iceDate;
    private String growLevel;
    private String growDate;
}
