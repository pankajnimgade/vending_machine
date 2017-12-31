package com.nimgade.pk.vendingmachine.activities.user.interaction.model;

import com.nimgade.pk.vendingmachine.application.model.currency.Currency;
import com.nimgade.pk.vendingmachine.application.model.product.Product;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public interface IUserInterfaceModel {

    /**
     * @param productType its a type of product
     * @return list of given productType
     */
    List<Product> getProductsList(int productType);

    /**
     * @param productType denotes a type of product
     * @return removes a product of this from {@link Inventory}
     */
    Product removeProduct(int productType);

    /**
     * @return the number of product user want to buy
     */
    int totalProductUserWantsToBuy();

    /**
     * @return instance of {@link Currency} which denotes, how much user needs to pay
     */
    Currency totalBill();

    /**
     * clears purchase
     */
    void clearPurchasedItems();
}
