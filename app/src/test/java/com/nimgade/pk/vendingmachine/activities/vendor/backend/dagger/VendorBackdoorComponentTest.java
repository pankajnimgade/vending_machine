package com.nimgade.pk.vendingmachine.activities.vendor.backend.dagger;

import com.nimgade.pk.vendingmachine.activities.vendor.backend.presenter.IVendorBackdoorPresenter;
import com.nimgade.pk.vendingmachine.application.dagger.DaggerRepositoriesComponent;
import com.nimgade.pk.vendingmachine.application.dagger.RepositoriesComponent;
import com.nimgade.pk.vendingmachine.application.model.product.Product;

import org.junit.Test;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */
public class VendorBackdoorComponentTest {

    @Test
    public void checkDaggerInjection() {
        RepositoriesComponent repositoriesComponent = DaggerRepositoriesComponent.create();
        VendorBackdoorComponent vendorBackdoorComponent =
                DaggerVendorBackdoorComponent.builder().repositoriesComponent(repositoriesComponent).build();

        IVendorBackdoorPresenter presenter = vendorBackdoorComponent.getIVendorBackdoorPresenter();
        System.out.println(presenter);

        for (int index = 0; index < 8; index++) {
            List<Product> productTypeList = presenter.getProductTypeList(index);
            for (Product currentProduct : productTypeList) {
                System.out.println(currentProduct);
            }
        }
    }

}