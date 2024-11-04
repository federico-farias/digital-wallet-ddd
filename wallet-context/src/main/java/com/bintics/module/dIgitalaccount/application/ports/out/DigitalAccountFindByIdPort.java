package com.bintics.module.dIgitalaccount.application.ports.out.digital;

import com.bintics.module.dIgitalaccount.domain.DigitalAccount;

@FunctionalInterface
public interface DigitalAccountFindByIdPort {

    DigitalAccount findById(Long id);
}
