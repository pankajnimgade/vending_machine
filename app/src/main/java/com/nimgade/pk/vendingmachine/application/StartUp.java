package com.nimgade.pk.vendingmachine.application;

import android.app.Application;

import com.nimgade.pk.vendingmachine.activities.user.interaction.dagger.DaggerUserInterfaceComponent;
import com.nimgade.pk.vendingmachine.activities.user.interaction.dagger.UserInterfaceComponent;
import com.nimgade.pk.vendingmachine.activities.user.interaction.dagger.UserInterfaceModule;
import com.nimgade.pk.vendingmachine.activities.vendor.backend.dagger.DaggerVendorBackdoorComponent;
import com.nimgade.pk.vendingmachine.activities.vendor.backend.dagger.VendorBackdoorComponent;
import com.nimgade.pk.vendingmachine.activities.vendor.backend.dagger.VendorBackdoorModule;
import com.nimgade.pk.vendingmachine.application.dagger.DaggerRepositoriesComponent;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 * <p>
 * Application level class used to keep reference to {@link Inventory} and to Use {@linkplain Dagger}
 */

public class StartUp extends Application {

    private Inventory inventory;

    private UserInterfaceComponent userInterfaceComponent;

    private VendorBackdoorComponent vendorBackdoorComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        inventory = DaggerRepositoriesComponent.create().getInventory();
        userInterfaceComponent =
                DaggerUserInterfaceComponent.builder()
                        .userInterfaceModule(new UserInterfaceModule(inventory))
                        .build();

        vendorBackdoorComponent =
                DaggerVendorBackdoorComponent.builder()
                        .vendorBackdoorModule(new VendorBackdoorModule(inventory))
                        .build();

    }

    public Inventory getInventory() {
        return inventory;
    }

    public UserInterfaceComponent getUserInterfaceComponent() {
        return userInterfaceComponent;
    }

    public VendorBackdoorComponent getVendorBackdoorComponent() {
        return vendorBackdoorComponent;
    }
}
