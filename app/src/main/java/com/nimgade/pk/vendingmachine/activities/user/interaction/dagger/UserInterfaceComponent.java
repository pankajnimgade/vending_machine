package com.nimgade.pk.vendingmachine.activities.user.interaction.dagger;

import com.nimgade.pk.vendingmachine.activities.user.interaction.presenter.IUserInterfacePresenter;
import com.nimgade.pk.vendingmachine.activities.user.interaction.view.UserInterfaceMainActivity;
import com.nimgade.pk.vendingmachine.application.repository.Inventory;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

@Singleton
@Component(modules = {UserInterfaceModule.class})
public interface UserInterfaceComponent {

    IUserInterfacePresenter getIUserInterfacePresenter();

    Inventory getInventory();

    void inject(UserInterfaceMainActivity view);
}
