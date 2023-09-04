package com.bintics.context.wallet.domain.model;

import lombok.Getter;

public class WalletBalance {

    @Getter
    private final Double value;

    public WalletBalance(Double value) {
        this.value = value;
    }

}
