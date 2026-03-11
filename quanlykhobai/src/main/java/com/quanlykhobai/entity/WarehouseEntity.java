package com.quanlykhobai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "warehouse")
@Data
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity companyentity;

    @Column(name = "warehouse_name")
    private String warehouseName;

    private String location;

    @Column(name = "area_default")
    private Double areaDefault;

    private String note;
}