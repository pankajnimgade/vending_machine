package com.nimgade.pk.vendingmachine.activities.vendor.backend.model;

import com.nimgade.pk.vendingmachine.application.model.product.Product;
import com.nimgade.pk.vendingmachine.application.model.product.ProductCreator;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */

public class VendorBackdoorModel implements IVendorBackdoorModel {

    @Inject
    public Inventory inventory;

    @Inject
    public VendorBackdoorModel(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void addProduct(int productType) {
        inventory.addProductToInventory(ProductCreator.getProduct(productType));
    }

    @Override
    public List<Product> getProductList(int productType) {
        return inventory.getListOfProducts(productType);
    }
}
