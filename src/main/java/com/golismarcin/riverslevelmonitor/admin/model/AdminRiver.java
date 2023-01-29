package com.golismarcin.riverslevelmonitor.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminRiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stationId;
    private String stationName;
    private String riverName;
    private String region;
    private Double waterLevel;
    private LocalDateTime waterDate;
    private Double waterTemp;
    private LocalDateTime  tempDate;
    private Double iceLevel;
    private LocalDateTime  iceDate;
    private Double growLevel;
    private LocalDateTime growDate;
}