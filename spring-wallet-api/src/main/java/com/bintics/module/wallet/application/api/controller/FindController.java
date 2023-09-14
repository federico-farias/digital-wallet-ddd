package com.bintics.module.wallet.application.api.controller;

import com.bintics.module.wallet.application.api.schema.FindHttpResponse;
import com.bintics.module.wallet.application.find.FindRequest;
import com.bintics.module.wallet.application.find.FindResponse;
import com.bintics.module.wallet.application.find.FindUseCase;
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
