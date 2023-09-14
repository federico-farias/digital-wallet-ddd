package com.bintics.module.customer.application.api.schema;

import lombok.Data;

@Data
public class CustomerRegistrarHttpRequest {
    private String documentNumber;
    private String phoneNumber;
    private String documentType;
    private String imei;
    private String email;
}
