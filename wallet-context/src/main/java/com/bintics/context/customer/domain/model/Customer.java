package com.bintics.context.customer.domain.model;

import com.bintics.context.customer.domain.event.RegisteredCustomerEvent;
import com.bintics.shared.AggregateRoot;

import java.util.Date;

public class Customer extends AggregateRoot {

    private CustomerId id;

    private CustomerPhoneNumber phoneNumber;

    private CustomerDocument document;

    private CustomerEmail email;

    private CustomerDate createdAt;

    private CustomerDate updatedAt;

    public Customer(CustomerPhoneNumber customerPhoneNumber, CustomerEmail customerEmail, CustomerDocument customerDocument, CustomerDate createdAt, CustomerDate updatedAt) {
        this.id = new CustomerId();
        this.phoneNumber = customerPhoneNumber;
        this.document = customerDocument;
        this.email = customerEmail;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Customer create(String phoneNumber, String email, String documentNumber, String documentType) {
        Customer customer = new Customer(
                new CustomerPhoneNumber(phoneNumber),
                new CustomerEmail(email),
                new CustomerDocument(documentNumber, documentType),
                new CustomerDate(),
                new CustomerDate()
        );
        customer.record(new RegisteredCustomerEvent(customer.id.getValue()));
        return customer;
    }

    public String getId() {
        return this.id.getValue();
    }

    public String getDocumentNumber() {
        return this.document.getDocumentNumber();
    }

    public String getDocumentType() {
        return this.document.getDocumentType();
    }

    public String getPhoneNumber() {
        return this.phoneNumber.getValue();
    }

    public String getEmail() {
        return this.email.getValue();
    }

    public Date getCreatedAt() {
        return this.createdAt.getValue();
    }

    public Date getUpdatedAt() {
        return this.updatedAt.getValue();
    }

}
