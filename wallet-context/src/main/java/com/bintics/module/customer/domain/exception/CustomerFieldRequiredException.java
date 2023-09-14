package com.bintics.module.customer.domain.exception;

import com.bintics.shared.BusinessException;

public class CustomerFieldRequiredException extends BusinessException {

    public CustomerFieldRequiredException(String message) {
        super(message);
    }

}
