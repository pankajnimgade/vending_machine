package com.nimgade.pk.vendingmachine.activities.user.interaction.model;

import com.nimgade.pk.vendingmachine.application.model.Product;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public class UserInterfaceModel implements IUserInterfaceModel {

    @Inject
    Inventory inventory;

    @Inject
    public UserInterfaceModel(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public List<Product> getProductsList(int productType) {
        return this.inventory.getListOfProducts(productType);
    }

    @Override
    public Product removeProduct(int productType) {
        return this.inventory.removeProductFromInventory(productType);
    }
}
