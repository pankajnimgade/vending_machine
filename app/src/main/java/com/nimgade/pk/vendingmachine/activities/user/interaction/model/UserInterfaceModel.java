package com.nimgade.pk.vendingmachine.activities.user.interaction.model;

import android.util.Log;

import com.nimgade.pk.vendingmachine.application.model.Product;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import java.math.BigDecimal;
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
    public double totalBill() {
        BigDecimal bill = new BigDecimal(0);
        bill.setScale(2, BigDecimal.ROUND_UP);
        if (!userBroughtProductList.isEmpty()) {
            for (Product product : userBroughtProductList) {
                bill =bill.add(new BigDecimal(product.getProductPrice()));
                bill.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                bill.stripTrailingZeros();
                Log.d(TAG, "totalBill: "+bill.doubleValue());
            }
        }

        return bill.doubleValue();
    }
}
