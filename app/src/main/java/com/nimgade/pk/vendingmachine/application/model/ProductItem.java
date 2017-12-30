package com.nimgade.pk.vendingmachine.application.model;

import android.support.annotation.NonNull;

import com.nimgade.pk.vendingmachine.application.model.currency.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public class ProductItem implements Product {

    private static int ID;
    private final int product_ID;
    private final int productType;
    private final String productName;
    private final Currency productPrice;

    {
        ID++;
    }

    public ProductItem(String productName, Currency price, int productType) {
        this.productName = productName;
        this.productPrice = price;
        this.productType = productType;
        product_ID = ID;
    }


    @Override
    public int getID() {
        return product_ID;
    }

    @Override
    public int getProductType() {
        return productType;
    }

    @Override
    public Currency getProductPrice() {
        return productPrice;
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "product_ID=" + product_ID +
                ", productType=" + productType +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    public static List<Product> initialize() {
        List<Product> productList = new ArrayList<>();

        Currency[] productPrice = new Currency[]{
                new Currency(2, 10),
                new Currency(5, 0),
                new Currency(15, 15),
                new Currency(80, 50),
                new Currency(4, 80),
                new Currency(34, 30),
                new Currency(20, 30),
                new Currency(12, 0)
        };

        for (int i = 0; i < 100; i++) {
            int currentPrice = new Random().nextInt(8);
            productList.add(new ProductItem("Name# " + currentPrice,
                    productPrice[currentPrice],
                    currentPrice));
        }
        return productList;
    }

    @Override
    public int compareTo(@NonNull Product o) {
        Product secondObject = (Product) o;
        if (this.getProductType() > secondObject.getProductType()) {
            return 1;
        } else if (this.getProductType() < secondObject.getProductType()) {
            return -1;
        }
        return 0;
    }
}
