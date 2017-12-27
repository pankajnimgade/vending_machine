package com.nimgade.pk.vendingmachine.application.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */
public class ProductItemTest {

    /**
     * This checks if the product ids are correctly generated for every product
     */
    @Test
    public void checkProductID() {
        List<Product> products = ProductItem.initialize();

        for (int index = 0; index < products.size(); index++) {
            Assert.assertEquals(index + 1, products.get(index).getID());
        }
    }


    @Test
    public void checkProductInitialize() {
        List<Product> products = new ArrayList<>();
        products.addAll(ProductItem.initialize());

        Collections.sort(products);
        for (int index = 1; index < products.size(); index++) {
            System.out.println(products.get(index));
        }
    }

}