package com.nimgade.pk.vendingmachine.activities.vendor.backend.model;

import com.nimgade.pk.vendingmachine.application.model.product.Product;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */

public interface IVendorBackdoorModel {

    void addProduct(int productType);

    List<Product> getProductList(int productType);
}
