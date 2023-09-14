package com.bintics.module.wallet.infrastructure.persistence;

import com.bintics.module.wallet.domain.model.*;
import com.bintics.module.wallet.domain.repository.WalletRepository;
import com.bintics.module.wallet.infrastructure.persistence.store.WalletEntity;
import com.bintics.module.wallet.infrastructure.persistence.store.WalletEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MySQLWalletRepositoryImpl implements WalletRepository {

    private WalletEntityRepository walletEntityRepository;

    @Override
    public void save(Wallet wallet) {
        WalletEntity entity = new WalletEntity();
        entity.setId(wallet.getId());
        entity.setCustomerId(wallet.getCustomerId());
        entity.setBalance(wallet.getBalance());
        entity.setCurrency(wallet.getCurrency());
        entity.setCreatedAt(wallet.getCreatedAt());
        entity.setUpdatedAt(wallet.getUpdatedAt());
        this.walletEntityRepository.save(entity);
    }

    @Override
    public Wallet find(WalletCustomerId customerId) {
        WalletEntity entity = this.walletEntityRepository.findByCustomerId(customerId.getValue());
        if (entity == null) {
            return null;
        }
        return new Wallet(
                new WalletId(entity.getId()),
                new WalletCustomerId(entity.getId()),
                new WalletBalance(entity.getBalance()),
                new WalletCurrency(entity.getCurrency()),
                new WalletDate(entity.getCreatedAt()),
                new WalletDate(entity.getUpdatedAt())
        );
    }

    @Override
    public Wallet find(WalletId id) {
        Wallet result = this.walletEntityRepository.findById(id.getValue())
                .map(e -> new Wallet(
                        new WalletId(e.getId()),
                        new WalletCustomerId(e.getCustomerId()),
                        new WalletBalance(e.getBalance()),
                        new WalletCurrency(e.getCurrency()),
                        new WalletDate(e.getCreatedAt()),
                        new WalletDate(e.getUpdatedAt())
                )).orElse(null);
        return result;
    }

}
