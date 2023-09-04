package com.bintics.context.wallet.application.search;

import com.bintics.context.wallet.domain.repository.WalletSearcherRepository;

public class SearchUseCase {

    private final WalletSearcherRepository walletSearcherRepository;

    public SearchUseCase(WalletSearcherRepository walletSearcherRepository) {
        this.walletSearcherRepository = walletSearcherRepository;
    }

    public SearchResponse query(SearchRequest request) {
        return this.walletSearcherRepository.search(request);
    }

}
