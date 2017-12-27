package com.nimgade.pk.vendingmachine.application;

import android.app.Application;

import com.nimgade.pk.vendingmachine.activities.user.interaction.dagger.DaggerUserInterfaceComponent;
import com.nimgade.pk.vendingmachine.activities.user.interaction.dagger.UserInterfaceComponent;
import com.nimgade.pk.vendingmachine.application.dagger.DaggerRepositoriesComponent;
import com.nimgade.pk.vendingmachine.application.model.Product;
import com.nimgade.pk.vendingmachine.application.model.ProductItem;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import javax.inject.Inject;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public class StartUp extends Application {

    @Inject
    Inventory inventory;

    private UserInterfaceComponent userInterfaceComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        inventory = DaggerRepositoriesComponent.create().getInventory();
        userInterfaceComponent = DaggerUserInterfaceComponent.create();
        for (Product product : ProductItem.initialize()) {
            userInterfaceComponent.getInventory().addProductToInventory(product);
        }

    }


    public Inventory getInventory() {
        return inventory;
    }

    public UserInterfaceComponent getUserInterfaceComponent() {
        return userInterfaceComponent;
    }
}
