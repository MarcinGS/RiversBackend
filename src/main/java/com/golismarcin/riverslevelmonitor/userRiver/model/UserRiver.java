package com.golismarcin.riverslevelmonitor.userRiver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long stationId;
    private String stationName;
    private String riverName;
    private String region;
    private Double waterLevel;
    private LocalDateTime  waterDate;
    private Double waterTemp;
    private LocalDateTime  tempDate;
    private Double iceLevel;
    private LocalDateTime  iceDate;
    private Double growLevel;
    private LocalDateTime growDate;
    @Type(type = "text")
    private String note;
    private String image;
}
