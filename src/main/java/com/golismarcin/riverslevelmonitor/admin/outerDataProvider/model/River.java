package com.golismarcin.riverslevelmonitor.admin.outerDataProvider.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class River {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long stationId;
    private String stationName;
    private String riverName;
    private Long regionId;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "river")
    private List<RiverMeasurement> measurements;

    public void addMeasurements(RiverMeasurement measurement){
        if(measurements == null){
            measurements = new ArrayList<>();
        }
        measurements.add(measurement);
    }
}


