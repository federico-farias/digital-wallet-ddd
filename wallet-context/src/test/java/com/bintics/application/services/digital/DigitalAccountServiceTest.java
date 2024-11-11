package com.bintics.application.services.digital;

import com.bintics.application.ports.out.digital.DigitalAccountCreatePort;
import com.bintics.application.ports.out.digital.DigitalAccountFindByIdPort;
import com.bintics.domain.digital.DigitalAccount;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DigitalAccountServiceTest {

    @Test
    void create() {

        DigitalAccountCreatePort digitalAccountCreatePort = new DigitalAccountCreatePort() {
            @Override
            public DigitalAccount create(DigitalAccount digitalAccount) {
                // return new DigitalAccount();
                digitalAccount.setId("123456789");
                return digitalAccount;
            }
        };

        DigitalAccountFindByIdPort digitalAccountFindByIdPort = new DigitalAccountFindByIdPort() {
            @Override
            public DigitalAccount findById(String id) {
                return new DigitalAccount();
            }
        };

        DigitalAccountService digitalAccountService = new DigitalAccountService(digitalAccountCreatePort, digitalAccountFindByIdPort);

        DigitalAccount digitalAccount = new DigitalAccount();
        digitalAccount.setDni("88884444");
        digitalAccount.setName("Esteban");
        digitalAccount.setBirthDate(LocalDate.of(1982, 2, 1));
        digitalAccount.setExpirationDate(LocalDate.of(2025, 2, 1));
        digitalAccount.setWalletNumber("000000091");

        DigitalAccount digitalAccountCreated = digitalAccountService.create(digitalAccount);

        // assertNotNull(digitalAccountCreated.getId());
        assertNotNull(digitalAccountCreated.getName());
        assertNotNull(digitalAccountCreated.getDni());
        assertNotNull(digitalAccountCreated.getBirthDate());
        assertNotNull(digitalAccountCreated.getExpirationDate());
        assertNotNull(digitalAccountCreated.getWalletNumber());
    }

    @Test
    void createFailWhenNameIsNull() {

        DigitalAccountCreatePort digitalAccountCreatePort = new DigitalAccountCreatePort() {
            @Override
            public DigitalAccount create(DigitalAccount digitalAccount) {
                // return new DigitalAccount();
                digitalAccount.setId("123456789");
                return digitalAccount;
            }
        };

        DigitalAccountFindByIdPort digitalAccountFindByIdPort = new DigitalAccountFindByIdPort() {
            @Override
            public DigitalAccount findById(String id) {
                return new DigitalAccount();
            }
        };

        DigitalAccountService digitalAccountService = new DigitalAccountService(digitalAccountCreatePort, digitalAccountFindByIdPort);

        DigitalAccount digitalAccount = new DigitalAccount();
        digitalAccount.setDni("88884444");
        // digitalAccount.setName("Esteban");
        digitalAccount.setBirthDate(LocalDate.of(1982, 2, 1));
        digitalAccount.setExpirationDate(LocalDate.of(2025, 2, 1));
        digitalAccount.setWalletNumber("000000091");

        // DigitalAccount digitalAccountCreated = digitalAccountService.create(digitalAccount);

        assertThrowsExactly(RuntimeException.class, () -> digitalAccountService.create(digitalAccount));

    }



}


/*
DigitalAccount {
    Customer, Wallet, .... fechareg, nivel, .....

}

Customer {
    name, dni, fechanac, sexo

}

Wallet {
    nrowallet, fechaexp, ammount, moneda

}

BD

Customer
Wallet
DigitalAccount
        */