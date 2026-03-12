use ql010226;
CREATE TABLE company (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(255),
    tax_code VARCHAR(50),
    address VARCHAR(255),
    phone VARCHAR(50),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_id BIGINT,
    type_customer VARCHAR(20), -- CTY / CANHAN
    name_of_customer VARCHAR(255),
    tax_code VARCHAR(50),
    id_card VARCHAR(50),
    address VARCHAR(255),
    email VARCHAR(100),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_customer_company
    FOREIGN KEY (company_id) REFERENCES company(id)
);
CREATE TABLE contract (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_id BIGINT,
    customer_id BIGINT,

    contract_code VARCHAR(50),
    date_signed DATE,
    date_start DATE,
    date_end DATE,
    contractstatus VARCHAR(30),
    note VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_contract_company 
        FOREIGN KEY (company_id) REFERENCES company(id),
    CONSTRAINT fk_contract_customer
        FOREIGN KEY (customer_id) REFERENCES customer(id)
);
CREATE TABLE contract_appendix (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contract_id BIGINT,
    appendix_no VARCHAR(50),
    signed_date DATE,
    effective_date DATE,
    note VARCHAR(255),

    CONSTRAINT fk_appendix_contract
        FOREIGN KEY (contract_id) REFERENCES contract(id)
);
CREATE TABLE warehouse (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_id BIGINT,
    warehouse_name VARCHAR(255),
    location VARCHAR(255),
    area_default DOUBLE,
    note VARCHAR(255),

    CONSTRAINT fk_warehouse_company
        FOREIGN KEY (company_id) REFERENCES company(id)
);
CREATE TABLE contract_warehouse_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contract_id BIGINT,
    appendix_id BIGINT NULL,
    warehouse_id BIGINT,
    rent_type VARCHAR(20), -- FIXED / M2
    price DOUBLE,
    area_m2 DOUBLE,
    valid_from DATE,
    valid_to DATE,
    note VARCHAR(255),

    CONSTRAINT fk_cwh_contract
        FOREIGN KEY (contract_id) REFERENCES contract(id),

    CONSTRAINT fk_cwh_appendix
        FOREIGN KEY (appendix_id) REFERENCES contract_appendix(id),

    CONSTRAINT fk_cwh_warehouse
        FOREIGN KEY (warehouse_id) REFERENCES warehouse(id)
);
CREATE TABLE electric_station (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    station_name VARCHAR(255),
    area VARCHAR(255)
);
CREATE TABLE electric_price_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    station_id BIGINT,

    price_peak DOUBLE,
    price_normal DOUBLE,
    price_offpeak DOUBLE,

    vat_percent DOUBLE,

    valid_from DATE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_electric_price_station
        FOREIGN KEY (station_id) REFERENCES electric_station(id)
);
CREATE TABLE service_price_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    company_id BIGINT,
    service_type VARCHAR(50), -- WATER / WASTE / OTHER

    area_name VARCHAR(255),
    price DOUBLE,

    valid_from DATE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_service_company
        FOREIGN KEY (company_id) REFERENCES company(id)
);
CREATE TABLE meter (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    warehouse_id BIGINT,
    meter_code VARCHAR(50),

    meter_type VARCHAR(20), -- ELECTRIC / WATER
    station_id BIGINT NULL,

    note VARCHAR(255),

    CONSTRAINT fk_meter_warehouse
        FOREIGN KEY (warehouse_id) REFERENCES warehouse(id),

    CONSTRAINT fk_meter_station
        FOREIGN KEY (station_id) REFERENCES electric_station(id)
);
CREATE TABLE meter_reading (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    meter_id BIGINT,
    period_month INT,
    period_year INT,
    date_from DATE,
    date_to DATE,
    old_peak DOUBLE,
    new_peak DOUBLE,
    old_normal DOUBLE,
    new_normal DOUBLE,
    old_offpeak DOUBLE,
    new_offpeak DOUBLE,
    old_water DOUBLE,
    new_water DOUBLE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_reading_meter
        FOREIGN KEY (meter_id) REFERENCES meter(id)
);
CREATE TABLE contract_service_policy (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contract_id BIGINT,
    appendix_id BIGINT NULL,
    service_type VARCHAR(30), -- ELECTRIC / WATER
    surcharge_percent DOUBLE, -- phụ thu 5% / 10%
    valid_from DATE,
    valid_to DATE,
    note VARCHAR(255),

    CONSTRAINT fk_policy_contract
        FOREIGN KEY (contract_id) REFERENCES contract(id),

    CONSTRAINT fk_policy_appendix
        FOREIGN KEY (appendix_id) REFERENCES contract_appendix(id)
);


