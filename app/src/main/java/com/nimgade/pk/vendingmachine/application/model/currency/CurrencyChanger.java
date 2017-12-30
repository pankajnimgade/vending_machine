package com.nimgade.pk.vendingmachine.application.model.currency;

/**
 * Created by Pankaj Nimgade on 12/29/2017.
 */

public abstract class CurrencyChanger {

    protected Currency currency;

    protected int _20_Dollars;
    protected int _5_Dollars;
    protected int _1_Dollar;
    protected int _25_Cents;
    protected int _10_Cents;
    protected int _05_Cents;
    protected int _01_Cent;

    public CurrencyChanger(Currency currency) {
        this.currency = currency;
    }

    public final CurrencyChanger getChange() {
        calculate_20_Dollars();
        calculate_5_Dollars();
        calculate_1_Dollars();
        calculate_25_Cents();
        calculate_10_Cents();
        calculate_5_Cents();
        calculate_1_Cents();
        return this;
    }

    abstract void calculate_20_Dollars();

    abstract void calculate_5_Dollars();

    abstract void calculate_1_Dollars();

    abstract void calculate_25_Cents();

    abstract void calculate_10_Cents();

    abstract void calculate_5_Cents();

    abstract void calculate_1_Cents();


    @Override
    public String toString() {
        return "$20 = " + _20_Dollars + "\n" +
                "$5 = " + _5_Dollars + "\n" +
                "$1 = " + _1_Dollar + "\n" +
                "$0.25 = " + _25_Cents + "\n" +
                "$0.10 = " + _10_Cents + "\n" +
                "$0.05 = " + _05_Cents + "\n" +
                "$0.01 = " + _01_Cent + "\n";
    }
}
