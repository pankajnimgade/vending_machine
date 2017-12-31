package com.nimgade.pk.vendingmachine.application.dagger;

import com.nimgade.pk.vendingmachine.application.model.product.Product;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import org.junit.Test;

import java.util.List;

/**
 * Created by Pankaj Nimgade on 12/30/2017.
 */
public class RepositoriesComponentTest {

    @Test
    public void checkDaggerInjection() {

        RepositoriesComponent repositoriesComponent = DaggerRepositoriesComponent.create();
        Inventory inventory = repositoriesComponent.getInventory();
        for (int index = 0; index < 8; index++) {
            List<Product> listOfProducts = inventory.getListOfProducts(index);
            for (Product currentProduct : listOfProducts) {
                System.out.println(currentProduct);
            }
        }
    }

}