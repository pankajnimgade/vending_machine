package com.nimgade.pk.vendingmachine.application.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
        List<Product> products = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            products.add(new ProductItem("Name # " + index, new Random().nextInt(10),new Random().nextInt(7)));
        }
        for (int index = 0; index < products.size(); index++) {
            Assert.assertEquals(index + 1, products.get(index).getID());
        }
    }

}