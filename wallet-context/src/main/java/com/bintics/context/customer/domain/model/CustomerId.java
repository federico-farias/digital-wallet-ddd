package com.bintics.context.customer.domain.model;

import com.bintics.context.customer.domain.exception.CustomerFieldRequiredException;
import lombok.Getter;

import java.util.UUID;

public class CustomerId {

    @Getter
    private final String value;

    public CustomerId() {
        this.value = UUID.randomUUID().toString();
    }

    public CustomerId(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new CustomerFieldRequiredException("customerId is required");
        }
        this.value = value;
    }

}
