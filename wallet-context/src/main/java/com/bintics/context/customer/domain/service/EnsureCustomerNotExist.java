package com.bintics.context.customer.domain.service;

import com.bintics.context.customer.domain.model.Customer;
import com.bintics.context.customer.domain.model.CustomerPhoneNumber;
import com.bintics.context.customer.domain.exception.CustomerAlreadyExistisException;
import com.bintics.context.customer.domain.repository.CustomerRepository;

public class EnsureCustomerNotExist {

    private final CustomerRepository customerRepository;

    public EnsureCustomerNotExist(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void ensure(CustomerPhoneNumber phoneNumber) {
        Customer customerFound = this.customerRepository.find(phoneNumber);
        if (customerFound != null) {
            throw new CustomerAlreadyExistisException(String.format("customer already exists [%s]", phoneNumber.getValue()));
        }
    }

}
