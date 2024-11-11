package com.bintics.adapters.in.apis.rest.mappers;

import com.bintics.adapters.in.apis.rest.dto.response.ResponseCreateDigitalAccountDTO;
import com.bintics.module.dIgitalaccount.domain.DigitalAccount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DigitalAccountResponseCreateMapper implements GenericMapper<DigitalAccount, ResponseCreateDigitalAccountDTO>{
    @Override
    public ResponseCreateDigitalAccountDTO map(DigitalAccount digitalAccount) {
        ResponseCreateDigitalAccountDTO responseCreateDigitalAccountDTO = new ResponseCreateDigitalAccountDTO();
        responseCreateDigitalAccountDTO.setId(digitalAccount.getId());
        responseCreateDigitalAccountDTO.setName(digitalAccount.getName());
        responseCreateDigitalAccountDTO.setDocumentNumber(digitalAccount.getDni());
        responseCreateDigitalAccountDTO.setWalletNumber(digitalAccount.getWalletNumber());
        responseCreateDigitalAccountDTO.setBirthDate(digitalAccount.getBirthDate());
        responseCreateDigitalAccountDTO.setExpirationDate(digitalAccount.getExpirationDate());
        return responseCreateDigitalAccountDTO;
    }

    @Override
    public List<ResponseCreateDigitalAccountDTO> lstMap(List<DigitalAccount> lstI) {
        return null;
    }
}

