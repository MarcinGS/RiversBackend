package com.golismarcin.riverslevelmonitor.outerDataProvider.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiverMeasurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double waterLevel;
    private LocalDateTime waterDate;
    private Double waterTemp;
    private LocalDateTime  tempDate;
    private Double iceLevel;
    private LocalDateTime  iceDate;
    private Double growLevel;
    private LocalDateTime growDate;
    private Long riverId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiverMeasurement that = (RiverMeasurement) o;
        return Objects.equals(waterLevel, that.waterLevel) && Objects.equals(waterDate, that.waterDate) && Objects.equals(waterTemp, that.waterTemp) && Objects.equals(tempDate, that.tempDate) && Objects.equals(iceLevel, that.iceLevel) && Objects.equals(iceDate, that.iceDate) && Objects.equals(growLevel, that.growLevel) && Objects.equals(growDate, that.growDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(waterLevel, waterDate, waterTemp, tempDate, iceLevel, iceDate, growLevel, growDate);
    }
}

