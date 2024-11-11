package com.bintics.adapters.in.apis.rest.mappers;

import com.bintics.adapters.in.apis.rest.dto.request.RequestCreateDigitalAccountDTO;
import com.bintics.module.dIgitalaccount.domain.DigitalAccount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// public class DigitalAccountRequestCreateMapper implements GenericMapper<DigitalAccount, DigitalAccountOracleEntity> {
public class DigitalAccountRequestCreateMapper implements GenericMapper<RequestCreateDigitalAccountDTO, DigitalAccount> {


    @Override
    public DigitalAccount map(RequestCreateDigitalAccountDTO requestCreateDigitalAccountDTO) {

        DigitalAccount digitalAccount = new DigitalAccount();
        digitalAccount.setName(requestCreateDigitalAccountDTO.getName());
        digitalAccount.setDni(requestCreateDigitalAccountDTO.getDni());
        digitalAccount.setBirthDate(requestCreateDigitalAccountDTO.getBirthDate());

        return digitalAccount;
    }

    @Override
    public List<DigitalAccount> lstMap(List<RequestCreateDigitalAccountDTO> lstRequestCreateDigitalAccountDTO) {
        return null;
    }
}
