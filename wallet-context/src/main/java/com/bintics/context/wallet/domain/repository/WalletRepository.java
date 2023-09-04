package com.bintics.context.wallet.domain.repository;

import com.bintics.context.wallet.application.search.SearchRequest;
import com.bintics.context.wallet.application.search.SearchResponse;
import com.bintics.context.wallet.domain.model.WalletCustomerId;
import com.bintics.context.wallet.domain.model.Wallet;
import com.bintics.context.wallet.domain.model.WalletId;

public interface WalletRepository {

    void save(Wallet wallet);

    Wallet find(WalletCustomerId customerId);

    Wallet find(WalletId id);

}
