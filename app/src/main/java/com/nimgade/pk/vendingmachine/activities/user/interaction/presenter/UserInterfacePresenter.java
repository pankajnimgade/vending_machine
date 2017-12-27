package com.nimgade.pk.vendingmachine.activities.user.interaction.presenter;

import com.nimgade.pk.vendingmachine.activities.user.interaction.model.IUserInterfaceModel;
import com.nimgade.pk.vendingmachine.activities.user.interaction.view.IUserInterfaceView;
import com.nimgade.pk.vendingmachine.application.model.Product;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public class UserInterfacePresenter implements IUserInterfacePresenter {

    @Inject
    public IUserInterfaceModel model;

    private IUserInterfaceView view;

    @Inject
    public UserInterfacePresenter(IUserInterfaceModel model) {
        this.model = model;
    }

    public void setView(IUserInterfaceView view) {
        this.view = view;
    }

    @Override
    public List<Product> getProductList(int productType) {
        return model.getProductsList(productType);
    }

    @Override
    public Product removeProduct(int productType) {
        Product product = model.removeProduct(productType);
        view.quantityOfProduct(model.totalProductUserWantsToBuy() + "");
        view.totalBillForQuantity(model.totalBill() + "");
        return product;
    }
}
