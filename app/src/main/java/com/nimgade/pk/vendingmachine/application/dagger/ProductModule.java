package com.nimgade.pk.vendingmachine.application.dagger;

import com.nimgade.pk.vendingmachine.application.repository.Inventory;
import com.nimgade.pk.vendingmachine.application.repository.MemoryInStockInventory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

@Singleton
@Module
public class ProductModule {

    @Singleton
    @Provides
    public Inventory getInventory() {
        return new MemoryInStockInventory();
    }
}
