package com.bintics.adapters.out.dbs.sql.mysql.jpa.mappers;

import com.bintics.adapters.out.dbs.sql.mysql.jpa.entities.DigitalAccountMySqlEntity;
import com.bintics.module.dIgitalaccount.domain.DigitalAccount;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// public class DigitalAccountRequestCreateMapper implements GenericMapper<DigitalAccount, DigitalAccountOracleEntity> {
public class DigitalAccountMySqlMapperImpl implements DigitalAccountMapper {


    @Override
    public DigitalAccountMySqlEntity toEntity(DigitalAccount digitalAccount) {
        DigitalAccountMySqlEntity digitalAccountMySqlEntity = new DigitalAccountMySqlEntity();
        // Id no se mapea
        digitalAccountMySqlEntity.setName(digitalAccount.getName());
        digitalAccountMySqlEntity.setDni(digitalAccount.getDni());
        digitalAccountMySqlEntity.setBirthDate(digitalAccount.getBirthDate());
        digitalAccountMySqlEntity.setWalletNumber(digitalAccount.getWalletNumber());
        digitalAccountMySqlEntity.setExpirationDate(digitalAccount.getExpirationDate());
        return digitalAccountMySqlEntity;
    }

    @Override
    public DigitalAccount toDomain(DigitalAccountMySqlEntity digitalAccountMySqlEntity) {
        DigitalAccount digitalAccount = new DigitalAccount();
        digitalAccount.setId(digitalAccountMySqlEntity.getId());
        digitalAccount.setName(digitalAccountMySqlEntity.getName());
        digitalAccount.setDni(digitalAccountMySqlEntity.getDni());
        digitalAccount.setBirthDate(digitalAccountMySqlEntity.getBirthDate());
        digitalAccount.setWalletNumber(digitalAccountMySqlEntity.getWalletNumber());
        digitalAccount.setExpirationDate(digitalAccountMySqlEntity.getExpirationDate());
        return digitalAccount;
    }

    @Override
    public List<DigitalAccount> toLstDomain(List<DigitalAccountMySqlEntity> listE) {
        return null;
    }

    @Override
    public List<DigitalAccountMySqlEntity> toLstEntity(List<DigitalAccount> listD) {
        return null;
    }
}
