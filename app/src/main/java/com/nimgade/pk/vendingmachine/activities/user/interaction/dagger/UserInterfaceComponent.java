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

    /**
     * its implementation will returns implementation of {{@link IUserInterfacePresenter}}
     *
     * @return {{@link IUserInterfacePresenter}}
     */
    IUserInterfacePresenter getIUserInterfacePresenter();

    /**
     * @param view {{@link UserInterfaceMainActivity}} is injected
     */
    void inject(UserInterfaceMainActivity view);
}
