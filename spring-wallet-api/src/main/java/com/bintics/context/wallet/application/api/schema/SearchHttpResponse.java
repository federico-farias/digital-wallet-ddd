package com.bintics.context.wallet.application.api.schema;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SearchHttpResponse {

    private final Integer total;

    private final List<SearchItemHttpResponse> items;

}
