package com.bintics.module.wallet.domain.model;

import com.bintics.shared.AggregateRoot;
import com.bintics.module.wallet.domain.event.WalletCreatedEvent;

import java.util.Date;

public class Wallet extends AggregateRoot {

    private WalletId id;

    private WalletCustomerId customerId;

    private WalletBalance balance;

    private WalletCurrency currency;

    private WalletDate createdAt;

    private WalletDate updatedAt;

    public Wallet(WalletId id, WalletCustomerId customerId, WalletBalance balance, WalletCurrency currency, WalletDate createdAt, WalletDate updatedAt) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
        this.currency = currency;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Wallet create(WalletCustomerId customerId) {
        Wallet wallet = new Wallet(
                new WalletId(),
                customerId,
                new WalletBalance(0.0),
                new WalletCurrency(),
                new WalletDate(),
                new WalletDate()
        );
        wallet.record(new WalletCreatedEvent(customerId.getValue()));
        return wallet;
    }

    public String getId() {
        return this.id.getValue();
    }

    public String getCustomerId() {
        return this.customerId.getValue();
    }

    public Double getBalance() {
        return this.balance.getValue();
    }

    public String getCurrency() {
        return this.currency.getValue();
    }

    public Date getCreatedAt() {
        return this.createdAt.getValue();
    }

    public Date getUpdatedAt() {
        return this.updatedAt.getValue();
    }

}
