package com.bintics.adapters.out.dbs.sql.oracle.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity(name = "DigitalAccountOracleEntity")
@Data
@Table(name="digital_accounts")
@SequenceGenerator(name="USER_SEQUENCE_GENERATOR", sequenceName="USER_SEQUENCE", initialValue=1, allocationSize=10)
public class DigitalAccountOracleEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQUENCE_GENERATOR")
    private Long id;
    private String name;
    private String dni;
    private LocalDate birthDate;
    private String walletNumber;
    private LocalDate expirationDate;

}

