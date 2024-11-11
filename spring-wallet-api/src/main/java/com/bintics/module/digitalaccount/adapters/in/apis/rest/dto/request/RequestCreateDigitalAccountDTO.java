package com.bintics.adapters.in.apis.rest.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RequestCreateDigitalAccountDTO {

    private String name;
    private String dni;
    private LocalDate birthDate;//YYYY-MM-DD "DD/MM/YYYY" "MM/DD/YY" LocalDateTime //YYYY-MM-DD HH:mi:ss.SSS

}


