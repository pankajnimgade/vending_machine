package com.nimgade.pk.vendingmachine.application.repository;

import com.nimgade.pk.vendingmachine.application.model.Product;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public interface Inventory {

    List<Product> getListOfProducts(int productType);

    void addProductToInventory(Product product);

    Product removeProductFromInventory(int productType);

}
