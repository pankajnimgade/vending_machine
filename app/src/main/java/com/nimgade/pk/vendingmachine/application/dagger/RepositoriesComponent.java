package com.nimgade.pk.vendingmachine.application.dagger;

import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

@Singleton
@Component(modules = {ProductModule.class})
public interface RepositoriesComponent {

    Inventory getInventory();
}
