package com.golismarcin.riverslevelmonitor.common.model;

import com.golismarcin.riverslevelmonitor.outerDataProvider.model.RiverMeasurement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Getter
@Builder
@Table(name = "river")
@NoArgsConstructor
@AllArgsConstructor
public class AdminRiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long stationId;
    private String stationName;
    private String riverName;
    @ManyToOne
    @JoinColumn(name = "regionId")
    private Region region;
    @OneToMany
    @JoinColumn(name = "riverId")
    private List<RiverMeasurement> measurements;
    private String image;
}
