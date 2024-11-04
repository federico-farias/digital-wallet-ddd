package com.bintics.adapters.in.apis.rest.mappers;

import java.util.List;

public interface GenericMapper<I, O> {

    O map(I i);

    List<O> lstMap(List<I> lstI);

}
