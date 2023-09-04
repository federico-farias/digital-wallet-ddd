package com.bintics.context.customer.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrarRequest {

    private String documentNumber;
    private String phoneNumber;
    private String documentType;
    private String imei;
    private String email;

}
