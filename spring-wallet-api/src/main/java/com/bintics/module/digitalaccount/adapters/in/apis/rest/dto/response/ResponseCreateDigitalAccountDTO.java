package com.bintics.adapters.in.apis.rest.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ResponseCreateDigitalAccountDTO {

    private Long id;
    private String name;
    private String documentNumber;
    private LocalDate birthDate;//YYYY-MM-DD "DD/MM/YYYY" "MM/DD/YY" LocalDateTime //YYYY-MM-DD HH:mi:ss.SSS
    private String walletNumber;
    private LocalDate expirationDate;

}


