package com.bintics.module.wallet.application.listener;

import com.bintics.module.customer.domain.event.RegisteredCustomerEvent;
import com.bintics.module.wallet.application.create.CreatorRequest;
import com.bintics.module.wallet.application.create.CreatorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisteredCustomerEventHandler {

    private final CreatorUseCase useCase;

    @EventListener
    public void on(RegisteredCustomerEvent event) {
        this.useCase.create(
                new CreatorRequest(event.getCustomerId())
        );
    }

}
