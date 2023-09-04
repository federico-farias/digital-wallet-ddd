package com.bintics.context.customer.domain.repository;

import com.bintics.context.customer.domain.model.Customer;
import com.bintics.context.customer.domain.model.CustomerPhoneNumber;

public interface CustomerRepository {

    void save(Customer customer);

    Customer find(CustomerPhoneNumber phoneNumber);

}
