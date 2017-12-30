package com.nimgade.pk.vendingmachine.application.model.currency;

/**
 * Created by Pankaj Nimgade on 12/29/2017.
 */

public class CurrencyUtils extends CurrencyChanger {

    public CurrencyUtils(Currency currency) {
        super(currency);
    }

    @Override
    void calculate_20_Dollars() {
        if (currency.compareTo(Change._20_Dollars.getCurrency()) >= 0) {
            _20_Dollars++;
            currency.reduceBy(Change._20_Dollars.getCurrency());
            calculate_20_Dollars();
        }
    }

    @Override
    void calculate_5_Dollars() {
        if (currency.compareTo(Change._5_dollars.getCurrency()) >= 0) {
            _5_Dollars++;
            currency.reduceBy(Change._5_dollars.getCurrency());
            calculate_5_Dollars();
        }
    }

    @Override
    void calculate_1_Dollars() {
        if (currency.compareTo(Change._1_dollar.getCurrency()) >= 0) {
            _1_Dollar++;
            currency.reduceBy(Change._1_dollar.getCurrency());
            calculate_1_Dollars();
        }
    }

    @Override
    void calculate_25_Cents() {
        if (currency.compareTo(Change._25_Cents.getCurrency()) >= 0) {
            _25_Cents++;
            currency.reduceBy(Change._25_Cents.getCurrency());
            calculate_25_Cents();
        }
    }

    @Override
    void calculate_10_Cents() {
        if (currency.compareTo(Change._10_Cents.getCurrency()) >= 0) {
            _10_Cents++;
            currency.reduceBy(Change._10_Cents.getCurrency());
            calculate_10_Cents();
        }
    }

    @Override
    void calculate_5_Cents() {
        if (currency.compareTo(Change._05_Cents.getCurrency()) >= 0) {
            _05_Cents++;
            currency.reduceBy(Change._05_Cents.getCurrency());
            calculate_5_Cents();
        }
    }

    @Override
    void calculate_1_Cents() {
        if (currency.compareTo(Change._01_Cent.getCurrency()) >= 0) {
            _01_Cent++;
            currency.reduceBy(Change._01_Cent.getCurrency());
            calculate_1_Cents();
        }
    }

}
