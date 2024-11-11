package com.bintics.module.customer.domain.exception;

import com.bintics.shared.BusinessException;

public class CustomerPhoneNoValidException extends BusinessException {

    public CustomerPhoneNoValidException(String message) {
        super(message);
    }

}
