package com.bintics.context.customer.application.api.controller;

import com.bintics.context.customer.application.RegistrarRequest;
import com.bintics.context.customer.application.RegistrarUseCase;
import com.bintics.context.customer.application.api.schema.CustomerRegistrarHttpRequest;
import com.bintics.context.customer.application.api.schema.CustomerRegisteredHttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerRegistrarController {

    private final RegistrarUseCase useCase;

    @PostMapping
    public ResponseEntity<CustomerRegisteredHttpResponse> registrar(@RequestBody CustomerRegistrarHttpRequest request) {
        String customerId = this.useCase.registrar(new RegistrarRequest(
                request.getDocumentNumber(),
                request.getPhoneNumber(),
                request.getDocumentType(),
                request.getImei(),
                request.getEmail()
        ));
        return ResponseEntity.created(URI.create(String.format("/customers/%s", customerId))).build();
    }

}
