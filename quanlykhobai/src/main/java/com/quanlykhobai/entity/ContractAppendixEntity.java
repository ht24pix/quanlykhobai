package com.quanlykhobai.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "contract_appendix")
@Data
public class ContractAppendixEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Liên kết về hợp đồng gốc
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private ContractEntity contract;

    @Column(name = "appendix_no")
    private String appendixNo;

    @Column(name = "signed_date")
    private LocalDate signedDate;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    private String note;
}