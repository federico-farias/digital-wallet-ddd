package com.bintics.module.wallet.infrastructure.persistence.store;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "wallet")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WalletEntity implements Serializable {

    @Id
    private String id;

    @Column
    private String customerId;

    @Column
    private Double balance;

    @Column
    private String currency;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;

}
