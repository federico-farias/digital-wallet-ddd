package com.bintics.context.customer.domain.exception;

import com.bintics.shared.BusinessException;

public class CustomerAlreadyExistisException extends BusinessException {

    public CustomerAlreadyExistisException(String message) {
        super(message);
    }

}
