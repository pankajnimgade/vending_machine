package com.nimgade.pk.vendingmachine.activities.user.interaction.dagger;

import com.nimgade.pk.vendingmachine.activities.user.interaction.model.IUserInterfaceModel;
import com.nimgade.pk.vendingmachine.activities.user.interaction.model.UserInterfaceModel;
import com.nimgade.pk.vendingmachine.activities.user.interaction.presenter.IUserInterfacePresenter;
import com.nimgade.pk.vendingmachine.activities.user.interaction.presenter.UserInterfacePresenter;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;
import com.nimgade.pk.vendingmachine.application.repository.MemoryInStockInventory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

@Module
public class UserInterfaceModule {

    @Provides
    @Singleton
    Inventory getInventory(){
        return new MemoryInStockInventory();
    }

    @Provides
    @Singleton
    IUserInterfaceModel providesIUserInterfaceModel(Inventory inventory) {
        return new UserInterfaceModel(inventory);
    }

    @Singleton
    @Provides
    IUserInterfacePresenter providesIUserInterfacePresenter(IUserInterfaceModel model) {
        return new UserInterfacePresenter(model);
    }

}
