package com.bintics.module.wallet.domain.exception;

import com.bintics.shared.BusinessException;

public class WalletAlreadyInUseExcetion extends BusinessException {

    public WalletAlreadyInUseExcetion(String message) {
        super(message);
    }

}
