package com.bintics.module.customer.infrastructure.persistence.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, String> {
    CustomerEntity findByPhoneNumber(String value);

}
