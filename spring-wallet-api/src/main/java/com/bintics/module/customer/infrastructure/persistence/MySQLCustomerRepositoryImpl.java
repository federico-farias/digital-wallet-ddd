package com.bintics.module.customer.infrastructure.persistence;

import com.bintics.module.customer.domain.model.*;
import com.bintics.module.customer.domain.repository.CustomerRepository;
import com.bintics.module.customer.infrastructure.persistence.store.CustomerEntity;
import com.bintics.module.customer.infrastructure.persistence.store.CustomerEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MySQLCustomerRepositoryImpl implements CustomerRepository {

    private final CustomerEntityRepository customerEntityRepository;

    @Override
    public void save(Customer customer) {
        CustomerEntity entity = new CustomerEntity();
        entity.setCustomerId(customer.getId());
        entity.setDocumentNumber(customer.getDocumentNumber());
        entity.setDocumentType(customer.getDocumentType());
        entity.setPhoneNumber(customer.getPhoneNumber());
        entity.setEmail(customer.getEmail());
        entity.setIsValid(true);// ¿Para que es este campo?
        entity.setCreatedAt(customer.getCreatedAt());
        entity.setUpdatedAt(customer.getUpdatedAt());
        this.customerEntityRepository.save(entity);
    }

    @Override
    public Customer find(CustomerPhoneNumber phoneNumber) {
        CustomerEntity entity = this.customerEntityRepository.findByPhoneNumber(phoneNumber.getValue());
        if (entity == null) {
            return null;
        }
        return new Customer(
                new CustomerPhoneNumber(entity.getPhoneNumber()),
                new CustomerEmail(entity.getEmail()),
                new CustomerDocument(
                        entity.getDocumentNumber(),
                        entity.getDocumentType()
                ),
                new CustomerDate(entity.getCreatedAt()),
                new CustomerDate(entity.getUpdatedAt())
        );
    }

}
