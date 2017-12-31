package com.nimgade.pk.vendingmachine.activities.user.interaction.presenter;

import com.nimgade.pk.vendingmachine.activities.user.interaction.view.IUserInterfaceView;
import com.nimgade.pk.vendingmachine.application.model.product.Product;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public interface IUserInterfacePresenter {

    List<Product> getProductList(int productType);

    Product removeProduct(int productType);

    void setView(IUserInterfaceView view);

    void showMessageToUser(String s);

    void makePayment();

    void purchaseWasMade();
}
