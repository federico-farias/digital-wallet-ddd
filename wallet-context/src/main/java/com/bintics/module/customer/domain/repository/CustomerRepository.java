package com.bintics.module.customer.domain.repository;

import com.bintics.module.customer.domain.model.Customer;
import com.bintics.module.customer.domain.model.CustomerPhoneNumber;

public interface CustomerRepository {

    void save(Customer customer);

    Customer find(CustomerPhoneNumber phoneNumber);

}
