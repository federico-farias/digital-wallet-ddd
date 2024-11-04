package com.bintics.module.dIgitalaccount.application.ports.out.digital;

import com.bintics.module.dIgitalaccount.domain.DigitalAccount;

@FunctionalInterface
public interface DigitalAccountCreatePort {

    DigitalAccount create(DigitalAccount digitalAccount);
}
