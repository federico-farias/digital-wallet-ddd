package com.bintics.context.wallet.domain.exception;

import com.bintics.shared.BusinessException;

public class WalletCurrencyInvalidExcetion extends BusinessException {

    public WalletCurrencyInvalidExcetion(String message) {
        super(message);
    }

}
