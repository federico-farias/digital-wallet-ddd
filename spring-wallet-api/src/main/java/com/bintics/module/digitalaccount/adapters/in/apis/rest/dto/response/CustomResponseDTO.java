package com.bintics.adapters.in.apis.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponseDTO {

    private String api;
    private String code;
    private String message;
    private Object response;

}
