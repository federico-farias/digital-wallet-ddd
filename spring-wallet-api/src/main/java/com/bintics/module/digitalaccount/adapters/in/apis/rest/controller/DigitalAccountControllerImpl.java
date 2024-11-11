package com.bintics.adapters.in.apis.rest.controller;

import com.bintics.adapters.in.apis.rest.dto.request.RequestCreateDigitalAccountDTO;
import com.bintics.adapters.in.apis.rest.dto.response.ResponseCreateDigitalAccountDTO;
import com.bintics.adapters.in.apis.rest.mappers.DigitalAccountRequestCreateMapper;
import com.bintics.adapters.in.apis.rest.mappers.DigitalAccountResponseCreateMapper;
import com.bintics.module.dIgitalaccount.application.ports.in.digital.DigitalAccountCreateUseCase;
import com.bintics.module.dIgitalaccount.application.ports.in.digital.DigitalAccountFindByIdUseCase;
import com.bintics.module.dIgitalaccount.domain.DigitalAccount;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DigitalAccountControllerImpl extends GenericController implements DigitalAccountController {

    private final DigitalAccountCreateUseCase digitalAccountCreateUseCase;
    private final DigitalAccountFindByIdUseCase digitalAccountFindByIdUseCase;

    private final DigitalAccountRequestCreateMapper digitalAccountRequestCreateMapper;
    private final DigitalAccountResponseCreateMapper digitalAccountResponseCreateMapper;


//    public DigitalAccountControllerImpl(DigitalAccountCreateUseCase digitalAccountCreateUseCase, DigitalAccountFindByIdUseCase digitalAccountFindByIdUseCase){
//        this.digitalAccountCreateUseCase = digitalAccountCreateUseCase;
//        this.digitalAccountFindByIdUseCase = digitalAccountFindByIdUseCase;
//    }

    @Override
    public ResponseEntity<?> createDigitalAccount(@RequestBody RequestCreateDigitalAccountDTO requestCreateDigitalAccount) {
        DigitalAccount digitalAccount = digitalAccountRequestCreateMapper.map(requestCreateDigitalAccount);
        DigitalAccount digitalAccountCreated = digitalAccountCreateUseCase.create(digitalAccount);
        ResponseCreateDigitalAccountDTO responseCreateDigitalAccountDTO = digitalAccountResponseCreateMapper.map(digitalAccountCreated);
        return created(responseCreateDigitalAccountDTO);
    }

    @Override
    public ResponseEntity<?> findById(String id) {
        return null;
    }
}
