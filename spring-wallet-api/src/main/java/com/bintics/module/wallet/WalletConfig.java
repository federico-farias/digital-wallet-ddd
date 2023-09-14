package com.bintics.module.wallet;

import com.bintics.module.wallet.application.find.FindUseCase;
import com.bintics.module.wallet.application.search.SearchUseCase;
import com.bintics.module.wallet.domain.repository.WalletSearcherRepository;
import com.bintics.shared.DomainEventPubisher;
import com.bintics.module.wallet.application.create.CreatorUseCase;
import com.bintics.module.wallet.domain.repository.WalletRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    @Bean
    public CreatorUseCase creatorWalletUseCase(DomainEventPubisher domainEventPubisher, WalletRepository walletRepository) {
        return new CreatorUseCase(domainEventPubisher, walletRepository);
    }

    @Bean
    public FindUseCase getBalanceUseCase(WalletRepository walletRepository) {
        return new FindUseCase(walletRepository);
    }

    @Bean
    public SearchUseCase searchUseCase(WalletSearcherRepository walletSearcherRepository) {
        return new SearchUseCase(walletSearcherRepository);
    }

}
