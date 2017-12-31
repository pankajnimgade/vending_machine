package com.nimgade.pk.vendingmachine.activities.user.interaction.model;

import com.nimgade.pk.vendingmachine.application.model.currency.Currency;
import com.nimgade.pk.vendingmachine.application.model.product.Product;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public interface IUserInterfaceModel {

    List<Product> getProductsList(int productType);

    Product removeProduct(int productType);

    int totalProductUserWantsToBuy();

    Currency totalBill();
    void  clearPurchasedItems();
}
