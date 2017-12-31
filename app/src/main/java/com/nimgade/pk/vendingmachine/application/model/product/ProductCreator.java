package com.nimgade.pk.vendingmachine.application.model.product;

import com.nimgade.pk.vendingmachine.application.model.currency.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */

public class ProductCreator {

    private static final Currency[] productPrice = new Currency[]{
            new Currency(2, 10),
            new Currency(5, 43),
            new Currency(15, 15),
            new Currency(80, 98),
            new Currency(4, 89),
            new Currency(34, 33),
            new Currency(20, 58),
            new Currency(12, 5)
    };


    public static Product getProduct(int productType) {
        return new ProductItem("Name# " + productType, productPrice[productType], productType);
    }

    public static List<Product> initialize() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int currentPrice = new Random().nextInt(8);
            productList.add(new ProductItem("Name# " + currentPrice,
                    productPrice[currentPrice],
                    currentPrice));
        }
        return productList;
    }
}
