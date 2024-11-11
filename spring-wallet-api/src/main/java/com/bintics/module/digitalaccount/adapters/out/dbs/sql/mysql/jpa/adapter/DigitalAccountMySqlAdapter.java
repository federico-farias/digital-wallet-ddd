package com.bintics.adapters.out.dbs.sql.mysql.jpa.adapter;

import com.bintics.adapters.out.dbs.sql.mysql.jpa.entities.DigitalAccountMySqlEntity;
import com.bintics.adapters.out.dbs.sql.mysql.jpa.mappers.DigitalAccountMapper;
import com.bintics.adapters.out.dbs.sql.mysql.jpa.repositories.DigitalAccountMySqlRepository;
import com.bintics.module.dIgitalaccount.application.ports.out.digital.DigitalAccountCreatePort;
import com.bintics.module.dIgitalaccount.application.ports.out.digital.DigitalAccountFindByIdPort;
import com.bintics.module.dIgitalaccount.domain.DigitalAccount;

import java.util.Optional;

public class DigitalAccountMySqlAdapter implements DigitalAccountCreatePort, DigitalAccountFindByIdPort {

    private final DigitalAccountMySqlRepository digitalAccountMySqlRepository;
    private final DigitalAccountMapper digitalAccountMapper;

    public DigitalAccountMySqlAdapter(DigitalAccountMySqlRepository digitalAccountMySqlRepository, DigitalAccountMapper digitalAccountMapper) {
        this.digitalAccountMySqlRepository = digitalAccountMySqlRepository;
        this.digitalAccountMapper = digitalAccountMapper;
    }

    @Override
    public DigitalAccount create(DigitalAccount digitalAccount) {
        DigitalAccountMySqlEntity digitalAccountMySqlEntity = digitalAccountMapper.toEntity(digitalAccount);
        return digitalAccountMapper.toDomain(digitalAccountMySqlRepository.save(digitalAccountMySqlEntity));
    }

    @Override
    public DigitalAccount findById(Long id) {
        Optional<DigitalAccountMySqlEntity> optionalDigitalAccountEntity = digitalAccountMySqlRepository.findById(id);
        if(optionalDigitalAccountEntity.isPresent())
            return digitalAccountMapper.toDomain(optionalDigitalAccountEntity.get());
        else
            throw new RuntimeException("---");
    }
}
