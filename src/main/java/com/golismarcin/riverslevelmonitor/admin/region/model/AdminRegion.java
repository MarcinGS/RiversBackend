package com.golismarcin.riverslevelmonitor.admin.region.model;

import com.golismarcin.riverslevelmonitor.common.model.RiverRegion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "region")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RiverRegion name;
}
