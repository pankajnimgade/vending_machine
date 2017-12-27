package com.nimgade.pk.vendingmachine.application.model;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public interface Product extends Comparable<Product> {

    int getID();

    int getProductType();

    double getProductPrice();

    String getName();


}
