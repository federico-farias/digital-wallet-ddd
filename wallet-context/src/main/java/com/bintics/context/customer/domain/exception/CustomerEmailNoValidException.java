package com.bintics.context.customer.domain.exception;

import com.bintics.shared.BusinessException;

public class CustomerEmailNoValidException extends BusinessException {

    public CustomerEmailNoValidException(String message) {
        super(message);
    }

}
