package com.bintics.adapters.in.apis.rest.controller;

import com.bintics.adapters.in.apis.rest.dto.request.RequestCreateDigitalAccountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bintics.adapters.in.apis.rest.controller.constants.APIConstants.API_DIGITALACCOUNT;

@RequestMapping(API_DIGITALACCOUNT)
public interface DigitalAccountController {

    @PostMapping
    ResponseEntity<?> createDigitalAccount(@RequestBody RequestCreateDigitalAccountDTO requestCreateDigitalAccount);

    @GetMapping(path = "/{:id}")
    ResponseEntity<?> findById(String id);
}
