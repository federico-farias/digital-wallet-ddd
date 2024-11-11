package com.bintics.adapters.out.dbs.sql.mysql.jpa.repositories;

import com.bintics.adapters.out.dbs.sql.mysql.jpa.entities.DigitalAccountMySqlEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitalAccountMySqlRepository extends GenericRepository<DigitalAccountMySqlEntity, Long> {
}
