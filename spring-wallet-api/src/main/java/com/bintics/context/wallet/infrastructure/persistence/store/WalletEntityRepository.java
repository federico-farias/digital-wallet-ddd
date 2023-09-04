package com.bintics.context.wallet.infrastructure.persistence.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletEntityRepository extends JpaRepository<WalletEntity, String> {

    WalletEntity findByCustomerId(String customerId);

}
