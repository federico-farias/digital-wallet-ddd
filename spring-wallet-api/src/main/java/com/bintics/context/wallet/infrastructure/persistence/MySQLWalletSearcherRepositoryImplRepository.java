package com.bintics.context.wallet.infrastructure.persistence;

import com.bintics.context.wallet.application.search.SearchRequest;
import com.bintics.context.wallet.application.search.SearchResponse;
import com.bintics.context.wallet.domain.repository.WalletSearcherRepository;
import org.springframework.stereotype.Repository;


// TODO: Impementar query con mongo
@Repository
public class MySQLWalletSearcherRepositoryImplRepository implements WalletSearcherRepository {

    @Override
    public SearchResponse search(SearchRequest request) {
        return null;
    }

}
