package com.nimgade.pk.vendingmachine.activities.user.interaction.model;

import com.nimgade.pk.vendingmachine.application.model.Currency;
import com.nimgade.pk.vendingmachine.application.model.Product;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public class UserInterfaceModel implements IUserInterfaceModel {

    private static final String TAG = "UserInterfaceModel";

    @Inject
    Inventory inventory;

    private List<Product> userBroughtProductList = new ArrayList<>();

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
        Product product = this.inventory.removeProductFromInventory(productType);
        if (product != null) {
            userBroughtProductList.add(product);
        }
        return product;
    }

    @Override
    public int totalProductUserWantsToBuy() {
        return userBroughtProductList.size();
    }

    @Override
    public Currency totalBill() {
        Currency billCurrency = new Currency(0, 0);
        if (!userBroughtProductList.isEmpty()) {
            for (Product product : userBroughtProductList) {
                billCurrency.addCurrency(product.getProductPrice());
            }
        }
        return billCurrency;
    }
}
