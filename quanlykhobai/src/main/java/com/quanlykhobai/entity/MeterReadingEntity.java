package com.quanlykhobai.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "meter_reading")
@Data
public class MeterReadingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meter_id")
    private MeterEntity meterEntity; // Yêu cầu bạn tạo thêm class Meter.java tương tự

    @Column(name = "period_month")
    private Integer periodMonth;

    @Column(name = "period_year")
    private Integer periodYear;

    @Column(name = "date_from")
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

    @Column(name = "old_peak")
    private Double oldPeak;

    @Column(name = "new_peak")
    private Double newPeak;

    @Column(name = "old_normal")
    private Double oldNormal;

    @Column(name = "new_normal")
    private Double newNormal;

    @Column(name = "old_offpeak")
    private Double oldOffpeak;

    @Column(name = "new_offpeak")
    private Double newOffpeak;

    @Column(name = "old_water")
    private Double oldWater;

    @Column(name = "new_water")
    private Double newWater;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;
}