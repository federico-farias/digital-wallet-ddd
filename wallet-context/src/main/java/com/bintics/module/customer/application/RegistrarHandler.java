package com.bintics.module.customer.application;

import com.bintics.module.customer.domain.model.Customer;
import com.bintics.module.customer.domain.model.CustomerPhoneNumber;
import com.bintics.module.customer.domain.repository.CustomerRepository;
import com.bintics.module.customer.domain.service.EnsureCustomerNotExist;
import com.bintics.shared.CommandHandler;
import com.bintics.shared.DomainEventPubisher;

public class RegistrarHandler implements CommandHandler<RegistrarCommand> {

    private final DomainEventPubisher domainEventPublisher;
    private final CustomerRepository customerRepository;
    private final EnsureCustomerNotExist ensureCustomerNotExist;

    public RegistrarHandler(DomainEventPubisher domainEventPublisher, CustomerRepository customerRepository) {
        this.domainEventPublisher = domainEventPublisher;
        this.customerRepository = customerRepository;
        this.ensureCustomerNotExist = new EnsureCustomerNotExist(customerRepository);
    }

    public void execute(RegistrarCommand request) {
        this.ensureCustomerNotExist.ensure(CustomerPhoneNumber.from(request.getPhoneNumber()));
        Customer customer = Customer.create(
                request.getPhoneNumber(),
                request.getEmail(),
                request.getDocumentNumber(),
                request.getDocumentType()
        );
        this.customerRepository.save(customer);
        this.domainEventPublisher.pubish(customer.pullEvents());
    }

}

