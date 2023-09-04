package com.bintics.context.wallet.application.search;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SearchItemResponse {

    private String id;

    private Double balance;

    private Date updatedAt;

}
