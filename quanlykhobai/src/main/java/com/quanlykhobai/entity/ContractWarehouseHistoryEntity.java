package com.quanlykhobai.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "contract_warehouse_history")
@Data
public class ContractWarehouseHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private ContractEntity contractentity;

    // Có thể null nếu là hợp đồng gốc, chưa có phụ lục
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appendix_id")
    private ContractEntity appendixentity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private WarehouseEntity warehouseentity;

    @Column(name = "rent_type")
    private String rentType; // FIXED hoặc M2

    private Double price;

    @Column(name = "area_m2")
    private Double areaM2;

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "valid_to")
    private LocalDate validTo;

    private String note;
}