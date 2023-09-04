package com.bintics.context.wallet.domain.service;

import com.bintics.context.wallet.domain.exception.WalletAlreadyInUseExcetion;
import com.bintics.context.wallet.domain.model.Wallet;
import com.bintics.context.wallet.domain.model.WalletCustomerId;
import com.bintics.context.wallet.domain.repository.WalletRepository;

public class MakeSureWalletIsNotInUse {

    private final WalletRepository walletRepository;

    public MakeSureWalletIsNotInUse(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public void ensure(WalletCustomerId customerId) {
        Wallet wallet = this.walletRepository.find(customerId);
        if (wallet != null) {
            throw new WalletAlreadyInUseExcetion("Wallet is already in use");
        }
    }

}
