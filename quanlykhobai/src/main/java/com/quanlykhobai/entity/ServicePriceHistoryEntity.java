package com.quanlykhobai.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_price_history")
@Data
public class ServicePriceHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @Column(name = "service_type")
    private String serviceType; // WATER / WASTE / OTHER

    @Column(name = "area_name")
    private String areaName;

    private Double price;

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}