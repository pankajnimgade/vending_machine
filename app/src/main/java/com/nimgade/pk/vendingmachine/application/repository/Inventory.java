package com.nimgade.pk.vendingmachine.application.repository;

import com.nimgade.pk.vendingmachine.application.model.product.Product;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 * <p>
 * its implementation will keep the stock of products of different type
 */

public interface Inventory {

    /**
     * @param productType
     * @return the list of product of a mentioned type
     */
    List<Product> getListOfProducts(int productType);

    /**
     * @param product is added to the stock of provided type
     */
    void addProductToInventory(Product product);

    /**
     * @param productType
     * @return this product is removed from the inventory
     */
    Product removeProductFromInventory(int productType);
}
