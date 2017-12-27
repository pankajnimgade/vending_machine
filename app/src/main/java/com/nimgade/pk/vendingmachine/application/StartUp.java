package com.nimgade.pk.vendingmachine.application;

import android.app.Application;

import com.nimgade.pk.vendingmachine.application.dagger.DaggerRepositoriesComponent;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import javax.inject.Inject;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

public class StartUp extends Application {

    @Inject
    Inventory inventory;

    @Override
    public void onCreate() {
        super.onCreate();
        inventory = DaggerRepositoriesComponent.create().getInventory();
    }


    public Inventory getInventory() {
        return inventory;
    }
}
