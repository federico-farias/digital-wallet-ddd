package com.bintics.context.customer.domain.model;

import com.bintics.context.customer.domain.exception.CustomerFieldRequiredException;
import lombok.Getter;

public class CustomerDocument {

    @Getter
    private final String documentNumber;

    @Getter
    private final String documentType;

    public CustomerDocument(String documentNumber, String documentType) {
        this.ensure(documentNumber, documentType);
        this.documentNumber = documentNumber;
        this.documentType = documentType;
    }

    private void ensure(String documentNumber, String documentType) {
        if (documentNumber == null || documentNumber.trim().isEmpty()) {
            throw new CustomerFieldRequiredException("documentNumber is required");
        }

        if (documentType == null || documentType.trim().isEmpty()) {
            throw new CustomerFieldRequiredException("documentType is required");
        }
    }

}
