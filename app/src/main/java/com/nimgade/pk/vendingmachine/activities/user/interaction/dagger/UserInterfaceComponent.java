package com.nimgade.pk.vendingmachine.activities.user.interaction.dagger;

import com.nimgade.pk.vendingmachine.activities.user.interaction.presenter.IUserInterfacePresenter;
import com.nimgade.pk.vendingmachine.activities.user.interaction.view.UserInterfaceMainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */

@Singleton
@Component(modules = {UserInterfaceModule.class})
public interface UserInterfaceComponent {

    IUserInterfacePresenter getIUserInterfacePresenter();

    void inject(UserInterfaceMainActivity view);
}
