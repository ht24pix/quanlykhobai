package com.quanlykhobai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "electric_station")
@Data
public class ElectricStationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_name")
    private String stationName;

    private String area;
}