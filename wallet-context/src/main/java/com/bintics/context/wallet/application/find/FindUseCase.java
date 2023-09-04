package com.bintics.context.wallet.application.find;

import com.bintics.context.wallet.domain.model.Wallet;
import com.bintics.context.wallet.domain.model.WalletId;
import com.bintics.context.wallet.domain.repository.WalletRepository;
import com.bintics.context.wallet.domain.service.WalletFinder;

public class FindUseCase {

    private final WalletFinder finder;

    public FindUseCase(WalletRepository walletRepository) {
        this.finder = new WalletFinder(walletRepository);
    }

    public FindResponse query(FindRequest request) {
        Wallet wallet = this.finder.find(WalletId.from(request.getWalletId()));
        return new FindResponse(
                wallet.getId(),
                wallet.getBalance(),
                wallet.getUpdatedAt()
        );
    }

}
