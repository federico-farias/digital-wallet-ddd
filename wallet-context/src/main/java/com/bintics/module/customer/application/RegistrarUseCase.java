package com.bintics.module.customer.application;

import com.bintics.module.customer.domain.model.Customer;
import com.bintics.module.customer.domain.model.CustomerPhoneNumber;
import com.bintics.module.customer.domain.repository.CustomerRepository;
import com.bintics.module.customer.domain.service.EnsureCustomerNotExist;
import com.bintics.shared.DomainEventPubisher;

public class RegistrarUseCase {

    private final DomainEventPubisher domainEventPublisher;
    private final CustomerRepository customerRepository;
    private final EnsureCustomerNotExist ensureCustomerNotExist;

    public RegistrarUseCase(DomainEventPubisher domainEventPublisher, CustomerRepository customerRepository) {
        this.domainEventPublisher = domainEventPublisher;
        this.customerRepository = customerRepository;
        this.ensureCustomerNotExist = new EnsureCustomerNotExist(customerRepository);
    }

    public String registrar(RegistrarRequest request) {
        this.ensureCustomerNotExist.ensure(CustomerPhoneNumber.from(request.getPhoneNumber()));
        Customer customer = Customer.create(
                request.getPhoneNumber(),
                request.getEmail(),
                request.getDocumentNumber(),
                request.getDocumentType()
        );
        this.customerRepository.save(customer);
        this.domainEventPublisher.pubish(customer.pullEvents());
        return customer.getId();
    }

}
