package com.nimgade.pk.vendingmachine.application.model.currency;

/**
 * Created by Pankaj Nimgade on 12/29/2017.
 */

public enum Change {

    _20_Dollars(new Currency(20, 0)),
    _5_dollars(new Currency(5, 0)),
    _1_dollar(new Currency(1, 0)),
    _25_Cents(new Currency(0, 25)),
    _10_Cents(new Currency(0, 10)),
    _05_Cents(new Currency(0, 5)),
    _01_Cent(new Currency(0, 1));

    private Currency currency;

    Change(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }
}
