package com.bintics.adapters.out.dbs.sql.oracle.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<E, ID> extends JpaRepository<E, ID> {

}
