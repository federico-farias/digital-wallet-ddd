package com.bintics.context.wallet.domain.model;

import com.bintics.context.wallet.domain.exception.WalletFieldRequiredException;
import lombok.Getter;

import java.util.UUID;

public class WalletId {

    @Getter
    private final String value;

    public WalletId() {
        this.value = UUID.randomUUID().toString();
    }

    public WalletId(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new WalletFieldRequiredException("walletId is required");
        }
        this.value = value;
    }

    public static WalletId from(String walletId) {
        return new WalletId(walletId);
    }

}
