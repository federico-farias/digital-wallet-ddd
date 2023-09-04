package com.bintics.context.customer.domain.event;

import com.bintics.shared.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class RegisteredCustomerEvent extends DomainEvent {

    private final String customerId;

    public RegisteredCustomerEvent(String customerId) {
        super();
        this.customerId = customerId;
    }

}
