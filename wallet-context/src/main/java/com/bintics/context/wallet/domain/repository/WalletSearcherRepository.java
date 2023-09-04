package com.bintics.context.wallet.domain.repository;

import com.bintics.context.wallet.application.search.SearchRequest;
import com.bintics.context.wallet.application.search.SearchResponse;

public interface WalletSearcherRepository {

    SearchResponse search(SearchRequest request);

}
