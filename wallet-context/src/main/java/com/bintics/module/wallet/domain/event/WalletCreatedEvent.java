package com.bintics.module.wallet.domain.event;

import com.bintics.shared.DomainEvent;
import lombok.Getter;

public class WalletCreatedEvent extends DomainEvent {

    @Getter
    private final String customerId;

    public WalletCreatedEvent(String customerId) {
        super();
        this.customerId = customerId;
    }

}
