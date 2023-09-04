package com.bintics.context.wallet.application.api.schema;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SearchItemHttpResponse {

    private String id;

    private Double balance;

    private Date updatedAt;

}
