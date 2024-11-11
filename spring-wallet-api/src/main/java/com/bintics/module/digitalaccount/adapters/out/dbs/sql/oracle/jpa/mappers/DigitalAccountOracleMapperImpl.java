package com.bintics.adapters.out.dbs.sql.oracle.jpa.mappers;

import com.bintics.adapters.out.dbs.sql.oracle.jpa.entities.DigitalAccountOracleEntity;
import com.bintics.module.dIgitalaccount.domain.DigitalAccount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DigitalAccountOracleMapperImpl implements DigitalAccountMapper {

    @Override
    public DigitalAccountOracleEntity toEntity(DigitalAccount digitalAccount) {
        DigitalAccountOracleEntity digitalAccountOracleEntity = new DigitalAccountOracleEntity();
        // Id no se mapea
        digitalAccountOracleEntity.setName(digitalAccount.getName());
        digitalAccountOracleEntity.setDni(digitalAccount.getDni());
        digitalAccountOracleEntity.setBirthDate(digitalAccount.getBirthDate());
        digitalAccountOracleEntity.setWalletNumber(digitalAccount.getWalletNumber());
        digitalAccountOracleEntity.setExpirationDate(digitalAccount.getExpirationDate());
        return digitalAccountOracleEntity;
    }

    @Override
    public DigitalAccount toDomain(DigitalAccountOracleEntity digitalAccountOracleEntity) {
        DigitalAccount digitalAccount = new DigitalAccount();
        digitalAccount.setId(digitalAccountOracleEntity.getId());
        digitalAccount.setName(digitalAccountOracleEntity.getName());
        digitalAccount.setDni(digitalAccountOracleEntity.getDni());
        digitalAccount.setBirthDate(digitalAccountOracleEntity.getBirthDate());
        digitalAccount.setWalletNumber(digitalAccountOracleEntity.getWalletNumber());
        digitalAccount.setExpirationDate(digitalAccountOracleEntity.getExpirationDate());
        return digitalAccount;
    }

    @Override
    public List<DigitalAccount> toLstDomain(List<DigitalAccountOracleEntity> listE) {
        return null;
    }

    @Override
    public List<DigitalAccountOracleEntity> toLstEntity(List<DigitalAccount> listD) {
        return null;
    }
}
