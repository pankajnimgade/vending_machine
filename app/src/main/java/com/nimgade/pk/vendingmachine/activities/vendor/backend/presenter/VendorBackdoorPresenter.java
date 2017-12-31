package com.nimgade.pk.vendingmachine.activities.vendor.backend.presenter;

import com.nimgade.pk.vendingmachine.activities.vendor.backend.model.IVendorBackdoorModel;
import com.nimgade.pk.vendingmachine.activities.vendor.backend.view.IVendorBackdoorActivityView;
import com.nimgade.pk.vendingmachine.application.model.product.Product;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */

public class VendorBackdoorPresenter implements IVendorBackdoorPresenter {

    @Inject
    public IVendorBackdoorModel model;

    private IVendorBackdoorActivityView view;

    @Inject
    public VendorBackdoorPresenter(IVendorBackdoorModel model) {
        this.model = model;
    }

    public void setView(IVendorBackdoorActivityView view) {
        this.view = view;
    }

    @Override
    public void addProduct(int productType) {
        model.addProduct(productType);
    }

    @Override
    public List<Product> getProductTypeList(int productType) {
        return model.getProductList(productType);
    }


}
