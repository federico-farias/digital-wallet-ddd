package com.bintics.adapters.out.dbs.sql.oracle.jpa.repositories;

import com.bintics.adapters.out.dbs.sql.oracle.jpa.entities.DigitalAccountOracleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitalAccountOracleRepository extends GenericRepository<DigitalAccountOracleEntity, Long> {
}
