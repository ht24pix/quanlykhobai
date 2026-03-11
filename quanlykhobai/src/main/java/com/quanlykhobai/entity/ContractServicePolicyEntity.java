package com.quanlykhobai.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "contract_service_policy")
@Data
public class ContractServicePolicyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private ContractEntity contractEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appendix_id")
    private ContractAppendixEntity appendixEntity;

    @Column(name = "service_type")
    private String serviceType; // ELECTRIC / WATER

    @Column(name = "surcharge_percent")
    private Double surchargePercent; // Phụ thu %

    @Column(name = "valid_from")
    private LocalDate validFrom;

    @Column(name = "valid_to")
    private LocalDate validTo;

    private String note;
}