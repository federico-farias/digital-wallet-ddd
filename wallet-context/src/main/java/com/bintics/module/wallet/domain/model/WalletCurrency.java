package com.bintics.module.wallet.domain.model;

import com.bintics.module.wallet.domain.exception.WalletCurrencyInvalidExcetion;

public class WalletCurrency {

    private final Currency currency;

    public WalletCurrency() {
        this.currency = Currency.MXN;
    }

    public WalletCurrency(String currency) {
        this.currency = this.getEnum(currency);
    }

    public String getValue() {
        return this.currency.toString();
    }

    private Currency getEnum(String currency) {
        try {
            return Currency.valueOf(currency);
        } catch (IllegalArgumentException ex) {
            throw new WalletCurrencyInvalidExcetion(String.format("currency no valid [%s]", currency));
        }
    }

    public enum Currency {
        MXN("MXN");

        private String value;

        Currency(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value.toUpperCase();
        }
    }

}
