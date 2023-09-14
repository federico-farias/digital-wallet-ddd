package com.bintics.module.customer.domain.model;

import com.bintics.module.customer.domain.exception.CustomerEmailNoValidException;
import com.bintics.module.customer.domain.exception.CustomerFieldRequiredException;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerEmail {

    private final String REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Getter
    private final String value;

    public CustomerEmail(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new CustomerFieldRequiredException("email is required");
        }
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new CustomerEmailNoValidException(String.format("email no valid [%s]", value));
        }
        this.value = value;
    }
}
