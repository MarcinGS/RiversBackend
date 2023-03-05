package com.golismarcin.riverslevelmonitor.outerDataProvider.model;

import com.golismarcin.riverslevelmonitor.common.model.Region;
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
import javax.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "riverId")
    private List<RiverMeasurement> measurements;

    public void addMeasurements(RiverMeasurement measurement){
        if(measurements == null){
            measurements = new ArrayList<>();
        }
        measurements.add(measurement);
    }

}


