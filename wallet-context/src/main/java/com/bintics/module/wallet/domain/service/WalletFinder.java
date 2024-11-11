package com.bintics.module.wallet.domain.service;

import com.bintics.module.wallet.domain.exception.WalletNotFoundException;
import com.bintics.module.wallet.domain.model.Wallet;
import com.bintics.module.wallet.domain.model.WalletId;
import com.bintics.module.wallet.domain.repository.WalletRepository;

public class WalletFinder {

    private final WalletRepository walletRepository;

    public WalletFinder(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet find(WalletId id) {
        Wallet wallet = this.walletRepository.find(id);
        if (wallet != null) {
            return wallet;
        }
        throw new WalletNotFoundException(String.format("wallet not found walletId: [%s]", id.getValue()));
    }

}
