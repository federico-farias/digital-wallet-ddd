package com.bintics.context.customer.domain.model;

import com.bintics.context.customer.domain.exception.CustomerFieldRequiredException;
import com.bintics.context.customer.domain.exception.CustomerPhoneNoValidException;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerPhoneNumber {

    private final String REGEX = "^\\d{10}$";

    @Getter
    private final String value;

    public CustomerPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new CustomerFieldRequiredException("phoneNumber is required");
        }
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.matches()) {
            throw new CustomerPhoneNoValidException(String.format("invalid phone number [%s]", phoneNumber));
        }
        this.value = phoneNumber;
    }

    public static CustomerPhoneNumber from(String phoneNumber) {
        return new CustomerPhoneNumber(phoneNumber);
    }

}
