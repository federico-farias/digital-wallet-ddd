package com.bintics.module.dIgitalaccount.application.services.digital;

import com.bintics.module.dIgitalaccount.application.ports.in.digital.DigitalAccountCreateUseCase;
import com.bintics.module.dIgitalaccount.application.ports.in.digital.DigitalAccountFindByIdUseCase;
import com.bintics.module.dIgitalaccount.application.ports.out.digital.DigitalAccountFindByIdPort;
import com.bintics.module.dIgitalaccount.application.ports.out.digital.DigitalAccountCreatePort;
import com.bintics.module.dIgitalaccount.domain.DigitalAccount;

public class DigitalAccountService implements DigitalAccountCreateUseCase, DigitalAccountFindByIdUseCase {

    private final DigitalAccountCreatePort digitalAccountCreatePort;
    private final DigitalAccountFindByIdPort digitalAccountFindByIdPort;

    public DigitalAccountService(DigitalAccountCreatePort digitalAccountCreatePort, DigitalAccountFindByIdPort digitalAccountFindByIdPort) {
        this.digitalAccountCreatePort = digitalAccountCreatePort;
        this.digitalAccountFindByIdPort = digitalAccountFindByIdPort;
    }

    @Override
    public DigitalAccount create(DigitalAccount digitalAccount) {

        /* INICIO validacion del objeto de domino */
        if(digitalAccount.getName()==null){
            throw new RuntimeException("Name requerido");
        }
        if(digitalAccount.getDni()==null){
            throw new RuntimeException("Dni requerido");
        }
        /* FIN validacion */

        DigitalAccount digitalAccountCreated = digitalAccountCreatePort.create(digitalAccount);
        // DigitalAccount digitalAccountCreated = digitalAccount;

//        if(digitalAccountCreated.getId()==null){
//            throw new RuntimeException("Id requerido");
//        }

        return digitalAccountCreated;
    }

    @Override
    public DigitalAccount findById(Long id) {
        return digitalAccountFindByIdPort.findById(id);
    }

}
