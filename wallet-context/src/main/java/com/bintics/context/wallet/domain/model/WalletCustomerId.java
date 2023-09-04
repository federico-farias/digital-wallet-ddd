package com.bintics.context.wallet.domain.model;

import com.bintics.context.wallet.domain.exception.WalletFieldRequiredException;
import lombok.Getter;

public class WalletCustomerId {

    @Getter
    private String value;

    public WalletCustomerId(String customerId) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new WalletFieldRequiredException("customerId is required");
        }
        this.value = customerId;
    }

    public static WalletCustomerId from(String customerId) {
        return new WalletCustomerId(customerId);
    }

}
