package com.bintics.adapters.out.dbs.sql.oracle.jpa.adapter;

import com.bintics.adapters.out.dbs.sql.oracle.jpa.entities.DigitalAccountOracleEntity;
import com.bintics.adapters.out.dbs.sql.oracle.jpa.mappers.DigitalAccountMapper;
import com.bintics.adapters.out.dbs.sql.oracle.jpa.repositories.DigitalAccountOracleRepository;
import com.bintics.module.dIgitalaccount.application.ports.out.digital.DigitalAccountCreatePort;
import com.bintics.module.dIgitalaccount.application.ports.out.digital.DigitalAccountFindByIdPort;
import com.bintics.module.dIgitalaccount.domain.DigitalAccount;

import java.util.Optional;

public class DigitalAccountOracleAdapter implements DigitalAccountCreatePort, DigitalAccountFindByIdPort {

    private final DigitalAccountOracleRepository digitalAccountOracleRepository;
    private final DigitalAccountMapper digitalAccountMapper;

    public DigitalAccountOracleAdapter(DigitalAccountOracleRepository digitalAccountOracleRepository, DigitalAccountMapper digitalAccountMapper) {
        this.digitalAccountOracleRepository = digitalAccountOracleRepository;
        this.digitalAccountMapper = digitalAccountMapper;
    }

    @Override
    public DigitalAccount create(DigitalAccount digitalAccount) {
        DigitalAccountOracleEntity digitalAccountOracleEntity = digitalAccountMapper.toEntity(digitalAccount);
        return digitalAccountMapper.toDomain(digitalAccountOracleRepository.save(digitalAccountOracleEntity));
    }

    @Override
    public DigitalAccount findById(Long id) {
        Optional<DigitalAccountOracleEntity> optionalDigitalAccountEntity = digitalAccountOracleRepository.findById(id);
        if(optionalDigitalAccountEntity.isPresent())
            return digitalAccountMapper.toDomain(optionalDigitalAccountEntity.get());
        else
            throw new RuntimeException("---");
    }
}
