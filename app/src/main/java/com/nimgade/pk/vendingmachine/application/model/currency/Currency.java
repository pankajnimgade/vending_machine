package com.nimgade.pk.vendingmachine.application.model.currency;

import org.jetbrains.annotations.NotNull;

/**
 * It's model data structure used to denote a type of currency used in this application
 */
public class Currency implements Comparable<Currency> {

    /**
     * denotes dollars
     */
    int dollars;
    /**
     * denotes cents
     */
    int cents;

    public Currency(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public int getCents() {
        return cents;
    }

    public int getDollars() {
        return dollars;
    }

    /**
     * @param currency money represented by this parameter is added to this instance's money
     */
    public void addCurrency(Currency currency) {
        this.dollars += currency.getDollars();
        this.cents += currency.getCents();
        if (this.cents >= 100) {
            this.cents -= 100;
            this.dollars++;
        }
    }

    /**
     * @param currency used to reduce a greater value of {@link Currency}
     * @return reduced value
     */
    public Currency reduceBy(Currency currency) {
        int tempDollars = this.dollars -= currency.dollars;
        int tempCents = this.cents -= currency.getCents();

        if (tempCents < 0) {
            tempDollars--;
            tempCents += 100;
        }
        return new Currency(tempDollars, tempCents);
    }

    @Override
    public String toString() {
        String result = "";
        result += this.dollars;
        String fraction = (float) this.cents / 100 + "";
        for (int index = 1; index < fraction.toCharArray().length; index++) {
            result += fraction.charAt(index);
        }
        return result;
    }

    @Override
    public int compareTo(@NotNull Currency currency) {
        if (currency != null) {
            if (this.dollars > currency.getDollars()) {
                return 1;
            } else if (this.dollars == currency.getDollars()) {
                if (this.cents > currency.getCents()) {
                    return 1;
                } else if (this.cents < currency.getCents()) {
                    return -1;
                }
            } else if (this.dollars < currency.getDollars()) {
                return -1;
            }
        }
        return 0;
    }
}
