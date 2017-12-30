package com.nimgade.pk.vendingmachine.application.model;

import com.nimgade.pk.vendingmachine.application.model.currency.Currency;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public interface Product extends Comparable<Product> {

    int getID();

    int getProductType();

    Currency getProductPrice();

    String getName();


}
