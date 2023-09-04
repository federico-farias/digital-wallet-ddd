package com.bintics.context.wallet.domain.event;

import com.bintics.shared.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

public class WalletCreatedEvent extends DomainEvent {

    @Getter
    private final String customerId;

    public WalletCreatedEvent(String customerId) {
        super();
        this.customerId = customerId;
    }

}
