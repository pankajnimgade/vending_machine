package com.nimgade.pk.vendingmachine.activities.vendor.backend.dagger;

import com.nimgade.pk.vendingmachine.activities.vendor.backend.model.IVendorBackdoorModel;
import com.nimgade.pk.vendingmachine.activities.vendor.backend.model.VendorBackdoorModel;
import com.nimgade.pk.vendingmachine.activities.vendor.backend.presenter.IVendorBackdoorPresenter;
import com.nimgade.pk.vendingmachine.activities.vendor.backend.presenter.VendorBackdoorPresenter;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */

@Module
public class VendorBackdoorModule {

    Inventory inventory;

    public VendorBackdoorModule(Inventory inventory) {
        this.inventory = inventory;
    }

    @Singleton
    @Provides
    public Inventory providesInventory() {
        return inventory;
    }

    @Singleton
    @Provides
    IVendorBackdoorModel providesIVendorBackdoorModel(Inventory inventory) {
        return new VendorBackdoorModel(inventory);
    }

    @Singleton
    @Provides
    IVendorBackdoorPresenter providesIVendorBackdoorPresenter(IVendorBackdoorModel model) {
        return new VendorBackdoorPresenter(model);
    }
}
