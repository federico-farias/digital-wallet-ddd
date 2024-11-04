package com.bintics.module.dIgitalaccount.application.ports.in.digital;

import com.bintics.module.dIgitalaccount.domain.DigitalAccount;

@FunctionalInterface
public interface DigitalAccountCreateUseCase {

    DigitalAccount create(DigitalAccount digitalAccount);
}
