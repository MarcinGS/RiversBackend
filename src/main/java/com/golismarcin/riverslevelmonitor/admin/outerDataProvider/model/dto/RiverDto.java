package com.golismarcin.riverslevelmonitor.admin.outerDataProvider.model.dto;

import lombok.Getter;

@Getter
public class RiverDto {
    public String id_stacji;
    public String stacja;
    public String rzeka;
    public String województwo;
    public String stan_wody;
    public String stan_wody_data_pomiaru;
    public String temperatura_wody;
    public String temperatura_wody_data_pomiaru;
    public String zjawisko_lodowe;
    public String zjawisko_lodowe_data_pomiaru;
    public String zjawisko_zarastania;
    public String zjawisko_zarastania_data_pomiaru;
}
