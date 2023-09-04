package com.bintics.context.wallet.domain.exception;

import com.bintics.shared.NotFoundException;

public class WalletNotFoundException extends NotFoundException {

    public WalletNotFoundException(String message) {
        super(message);
    }

}
