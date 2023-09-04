package com.bintics.context.customer.application.api.schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorHttpResponse {

    private String message;

    private Integer statusCode;

}
