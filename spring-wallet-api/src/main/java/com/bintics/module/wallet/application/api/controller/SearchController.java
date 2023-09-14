package com.bintics.module.wallet.application.api.controller;

import com.bintics.module.wallet.application.api.schema.SearchHttpResponse;
import com.bintics.module.wallet.application.api.schema.SearchItemHttpResponse;
import com.bintics.module.wallet.application.search.SearchRequest;
import com.bintics.module.wallet.application.search.SearchResponse;
import com.bintics.module.wallet.application.search.SearchUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wallets")
@AllArgsConstructor
public class SearchController {

    private final SearchUseCase useCase;

    @GetMapping
    public ResponseEntity<SearchHttpResponse> find(@RequestParam("customerId") String customerId) {
        SearchResponse result = this.useCase.query(new SearchRequest(customerId));
        List<SearchItemHttpResponse> items = result.getItems()
                .stream()
                .map(i -> new SearchItemHttpResponse(
                        i.getId(),
                        i.getBalance(),
                        i.getUpdatedAt()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new SearchHttpResponse(
                result.getTotal(),
                items
        ));
    }

}
