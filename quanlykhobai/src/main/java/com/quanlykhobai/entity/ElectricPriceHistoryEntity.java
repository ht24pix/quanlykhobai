package com.quanlykhobai.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "electric_price_history")
@Data
public class ElectricPriceHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private ElectricStationEntity station;

    @Column(name = "price_peak")
    private Double pricePeak;

    @Column(name = "price_normal")
    private Double priceNormal;

    @Column(name = "price_offpeak")
    private Double priceOffpeak;

    @Column(name = "vat_percent")
    private Double vatPercent;

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}