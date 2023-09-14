package com.bintics.module.customer;

import com.bintics.module.customer.application.RegistrarUseCase;
import com.bintics.module.customer.domain.repository.CustomerRepository;
import com.bintics.shared.DomainEventPubisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    public RegistrarUseCase customerRegistrarUseCase(DomainEventPubisher domainEventPublisher, CustomerRepository customerRepository) {
        return new RegistrarUseCase(domainEventPublisher, customerRepository);
    }

}
