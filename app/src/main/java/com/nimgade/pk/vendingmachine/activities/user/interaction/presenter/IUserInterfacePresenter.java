package com.nimgade.pk.vendingmachine.activities.user.interaction.presenter;

import com.nimgade.pk.vendingmachine.activities.user.interaction.view.IUserInterfaceView;
import com.nimgade.pk.vendingmachine.application.model.product.Product;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public interface IUserInterfacePresenter {

    /**
     * @param productType its a type of product
     * @return list of given productType
     */
    List<Product> getProductList(int productType);

    /**
     * @param productType denotes a type of product
     * @return removes a product of this from {@link Inventory}
     */
    Product removeProduct(int productType);

    /**
     * @param view sets {@link IUserInterfaceView}'s implementation
     */
    void setView(IUserInterfaceView view);

    /**
     * @param s is message to the user to show
     */
    void showMessageToUser(String s);

    /**
     * make payment
     */
    void makePayment();

    /**
     * purchase confirmed, clean up time :)
     */
    void purchaseWasMade();
}
