package com.golismarcin.riverslevelmonitor.admin.region.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String name;
}
