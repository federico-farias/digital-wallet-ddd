package com.bintics.module.customer.application.api.controller;

import com.bintics.module.customer.application.RegistrarCommand;
import com.bintics.module.customer.application.api.schema.CustomerRegistrarHttpRequest;
import com.bintics.module.customer.application.api.schema.CustomerRegisteredHttpResponse;
import com.bintics.shared.CommandBus;
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

    private final CommandBus commandBus;

    @PostMapping
    public ResponseEntity<CustomerRegisteredHttpResponse> registrar(@RequestBody CustomerRegistrarHttpRequest request) {
        this.commandBus.execute(new RegistrarCommand(
                request.getDocumentNumber(),
                request.getPhoneNumber(),
                request.getDocumentType(),
                request.getImei(),
                request.getEmail()
        ));
        String customerId = "1234";
        return ResponseEntity.created(URI.create(String.format("/customers/%s", customerId))).build();
    }

}
