package com.bintics.context.wallet.application.api.controller;

import com.bintics.context.wallet.application.api.schema.FindHttpResponse;
import com.bintics.context.wallet.application.find.FindRequest;
import com.bintics.context.wallet.application.find.FindResponse;
import com.bintics.context.wallet.application.find.FindUseCase;
import com.bintics.context.wallet.application.api.schema.SearchHttpResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
@AllArgsConstructor
public class FindController {

    private final FindUseCase useCase;

    @GetMapping("/{id}")
    public ResponseEntity<FindHttpResponse> find(@PathVariable("id") String walletId) {
        FindResponse result = this.useCase.query(new FindRequest(walletId));
        return ResponseEntity.ok(new FindHttpResponse(
                result.getId(),
                result.getBalance(),
                result.getUpdatedAt()
        ));
    }

}
