package com.bintics.module.wallet.domain.repository;

import com.bintics.module.wallet.domain.model.WalletCustomerId;
import com.bintics.module.wallet.domain.model.Wallet;
import com.bintics.module.wallet.domain.model.WalletId;

public interface WalletRepository {

    void save(Wallet wallet);

    Wallet find(WalletCustomerId customerId);

    Wallet find(WalletId id);

}
