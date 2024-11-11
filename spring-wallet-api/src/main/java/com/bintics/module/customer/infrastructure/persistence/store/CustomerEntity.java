package com.bintics.module.customer.infrastructure.persistence.store;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "customer")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity implements Serializable {

    @Id
    private String customerId;

    @Column
    private String documentNumber;

    @Column
    private String documentType;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private Boolean isValid;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
