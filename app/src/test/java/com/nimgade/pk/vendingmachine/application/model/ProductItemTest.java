package com.nimgade.pk.vendingmachine.application.model;

import com.nimgade.pk.vendingmachine.application.model.product.Product;
import com.nimgade.pk.vendingmachine.application.model.product.ProductCreator;
import com.nimgade.pk.vendingmachine.application.model.product.ProductItem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */
public class ProductItemTest {

    /**
     * This checks if the product ids are correctly generated for every product
     */
    @Test
    public void checkProductID() {
        List<Product> products = ProductCreator.initialize();

        for (int index = 0; index < products.size(); index++) {
            Assert.assertEquals(index + 1, products.get(index).getID());
        }
    }


    @Test
    public void checkProductInitialize() {
        List<Product> products = new ArrayList<>();
        products.addAll(ProductCreator.initialize());

        Collections.sort(products);
        for (int index = 1; index < products.size(); index++) {
            System.out.println(products.get(index));
        }
    }

}