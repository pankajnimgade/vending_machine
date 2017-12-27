package com.nimgade.pk.vendingmachine.application.model;

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
    private final double productPrice;

    {
        ID++;
    }


    public ProductItem(String productName, double price, int productType) {
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
    public double getProductPrice() {
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

    public static List<Product> intialize() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            productList.add(new ProductItem("Name# " + i,
                    new Random().nextDouble() * 100,
                    new Random().nextInt(7) + 1));
        }
        return productList;
    }
}
