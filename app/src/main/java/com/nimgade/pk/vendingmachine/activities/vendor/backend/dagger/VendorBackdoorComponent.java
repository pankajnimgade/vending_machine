package com.nimgade.pk.vendingmachine.activities.vendor.backend.dagger;

import com.nimgade.pk.vendingmachine.activities.vendor.backend.presenter.IVendorBackdoorPresenter;
import com.nimgade.pk.vendingmachine.activities.vendor.backend.view.VendorBackdoorActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */

@Singleton
@Component(modules = {VendorBackdoorModule.class})
public interface VendorBackdoorComponent {

    IVendorBackdoorPresenter getIVendorBackdoorPresenter();

    void inject(VendorBackdoorActivity view);
}
