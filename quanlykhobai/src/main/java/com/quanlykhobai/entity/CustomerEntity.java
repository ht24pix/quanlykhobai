package com.quanlykhobai.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name="customer")
@Data
public class CustomerEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mapping khóa ngoại sang bảng Company
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CompanyEntity companyentity;

    @Column(name = "type_customer")
    private String typeCustomer; // CTY hoặc CANHAN

    @Column(name = "name_of_customer")
    private String nameOfCustomer;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "id_card")
    private String idCard;

    private String address;
    private String email;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDate createdAt;
}
