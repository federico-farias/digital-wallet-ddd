package com.bintics.adapters.out.dbs.sql.mysql.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="digital_accounts")
public class DigitalAccountMySqlEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dni;
    private LocalDate birthDate;
    private String walletNumber;
    private LocalDate expirationDate;

}

