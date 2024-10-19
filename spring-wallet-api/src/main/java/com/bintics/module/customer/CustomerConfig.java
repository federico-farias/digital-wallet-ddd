package com.bintics.module.customer;

import com.bintics.module.customer.application.RegistrarHandler;
import com.bintics.module.customer.domain.repository.CustomerRepository;
import com.bintics.shared.CommandBus;
import com.bintics.shared.CommandBusImpl;
import com.bintics.shared.CommandHandler;
import com.bintics.shared.DomainEventPubisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    public RegistrarHandler customerRegistrarUseCase(DomainEventPubisher domainEventPublisher, CustomerRepository customerRepository) {
        return new RegistrarHandler(domainEventPublisher, customerRepository);
    }

    @Bean
    public CommandBus commandBusImpl(RegistrarHandler registrarUseCase) {
        List<CommandHandler> commandHandlers = new LinkedList<>();
        commandHandlers.add(registrarUseCase);
        return new CommandBusImpl(commandHandlers);
    }

}
