package com.bintics.context.wallet.application.find;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class FindResponse {

    private String id;

    private Double balance;

    public Date updatedAt;

}
