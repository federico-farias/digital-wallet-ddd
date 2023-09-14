package com.bintics.module.wallet.application.api.schema;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class FindHttpResponse {

    private String id;

    private Double balance;

    public Date updatedAt;

}
