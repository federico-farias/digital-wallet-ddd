package com.bintics.module.wallet.application.search;

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
public class SearchResponse {

    private final Integer total = 0;

    private final List<SearchItemResponse> items = new LinkedList<>();

}
