package com.bintics.adapters.out.dbs.sql.oracle.jpa.mappers;

import java.util.List;

public interface GenericMapper<D, E> {

    E toEntity(D d);

    D toDomain(E e);

    List<D> toLstDomain(List<E> listE);

    List<E> toLstEntity(List<D> listD);

}
