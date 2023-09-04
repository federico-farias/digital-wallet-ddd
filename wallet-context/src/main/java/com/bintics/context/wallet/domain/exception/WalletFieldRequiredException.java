package com.bintics.context.wallet.domain.exception;

import com.bintics.shared.BusinessException;

public class WalletFieldRequiredException extends BusinessException {

    public WalletFieldRequiredException(String message) {
        super(message);
    }

}
