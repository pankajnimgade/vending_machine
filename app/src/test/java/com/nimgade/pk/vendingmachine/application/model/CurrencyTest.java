package com.nimgade.pk.vendingmachine.application.model;

import com.nimgade.pk.vendingmachine.application.model.currency.Currency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Pankaj Nimgade on 12/27/2017.
 */
public class CurrencyTest {

    @Test
    public void checkCurrencyClass() {

        List<Currency> currencies = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            Currency currency =
                    new Currency(new Random().nextInt(10), new Random().nextInt(100));
            currencies.add(currency);
        }

        Collections.sort(currencies);
        for (Currency currency : currencies) {
            System.out.println(currency);
        }

        Currency currency = new Currency(0, 0);
        for (int index = 0; index < currencies.size(); index++) {
            Currency currentCurrency = currencies.get(index);
            System.out.print(currency + " + " + currentCurrency + " = ");
            currency.addCurrency(currentCurrency);
            System.out.println(currency);
        }
    }

}