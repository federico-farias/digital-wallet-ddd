package com.bintics.module.wallet.domain.repository;

import com.bintics.module.wallet.application.search.SearchRequest;
import com.bintics.module.wallet.application.search.SearchResponse;

public interface WalletSearcherRepository {

    SearchResponse search(SearchRequest request);

}
