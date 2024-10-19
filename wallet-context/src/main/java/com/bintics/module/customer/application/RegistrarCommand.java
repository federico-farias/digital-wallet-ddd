package com.bintics.module.customer.application;

import com.bintics.shared.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrarCommand extends Command {

    private String documentNumber;
    private String phoneNumber;
    private String documentType;
    private String imei;
    private String email;

}
