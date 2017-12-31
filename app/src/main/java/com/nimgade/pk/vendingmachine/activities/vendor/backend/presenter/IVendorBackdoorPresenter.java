package com.nimgade.pk.vendingmachine.activities.vendor.backend.presenter;

import com.nimgade.pk.vendingmachine.activities.vendor.backend.view.IVendorBackdoorActivityView;
import com.nimgade.pk.vendingmachine.application.model.product.Product;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */

public interface IVendorBackdoorPresenter {

    void setView(IVendorBackdoorActivityView view);

    void addProduct(int productType);

    List<Product> getProductTypeList(int productType);
}
