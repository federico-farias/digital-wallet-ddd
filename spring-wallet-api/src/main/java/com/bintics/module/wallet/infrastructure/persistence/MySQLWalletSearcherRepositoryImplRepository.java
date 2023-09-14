package com.bintics.module.wallet.infrastructure.persistence;

import com.bintics.module.wallet.application.search.SearchRequest;
import com.bintics.module.wallet.application.search.SearchResponse;
import com.bintics.module.wallet.domain.repository.WalletSearcherRepository;
import org.springframework.stereotype.Repository;


// TODO: Impementar query con mongo
@Repository
public class MySQLWalletSearcherRepositoryImplRepository implements WalletSearcherRepository {

    @Override
    public SearchResponse search(SearchRequest request) {
        return null;
    }

}
