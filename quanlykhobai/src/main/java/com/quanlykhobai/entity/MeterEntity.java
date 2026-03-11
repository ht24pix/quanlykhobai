package com.quanlykhobai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "meter")
@Data
public class MeterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private WarehouseEntity warehouse;

    @Column(name = "meter_code")
    private String meterCode;

    @Column(name = "meter_type")
    private String meterType; // ELECTRIC / WATER

    // Có thể null nếu là đồng hồ nước
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private ElectricStationEntity station;

    private String note;
}