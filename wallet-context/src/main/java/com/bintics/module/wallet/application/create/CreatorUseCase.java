package com.bintics.module.wallet.application.create;

import com.bintics.shared.DomainEventPubisher;
import com.bintics.module.wallet.domain.model.Wallet;
import com.bintics.module.wallet.domain.model.WalletCustomerId;
import com.bintics.module.wallet.domain.repository.WalletRepository;
import com.bintics.module.wallet.domain.service.MakeSureWalletIsNotInUse;

public class CreatorUseCase {

    private final DomainEventPubisher publisher;
    private final WalletRepository walletRepository;

    private final MakeSureWalletIsNotInUse makeSureWalletIsNotInUse;


    public CreatorUseCase(DomainEventPubisher publisher, WalletRepository walletRepository) {
        this.publisher = publisher;
        this.walletRepository = walletRepository;
        this.makeSureWalletIsNotInUse = new MakeSureWalletIsNotInUse(walletRepository);
    }

    public void create(CreatorRequest request) {
        WalletCustomerId customerId = WalletCustomerId.from(request.getCustomerId());
        this.makeSureWalletIsNotInUse.ensure(customerId);

        Wallet wallet = Wallet.create(customerId);
        this.walletRepository.save(wallet);

        this.publisher.pubish(wallet.pullEvents());
    }

}
