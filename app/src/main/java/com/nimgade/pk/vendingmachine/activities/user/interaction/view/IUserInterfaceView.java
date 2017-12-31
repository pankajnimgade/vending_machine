package com.nimgade.pk.vendingmachine.activities.user.interaction.view;

import com.nimgade.pk.vendingmachine.application.model.currency.Currency;

/**
 * Created by Pankaj Nimgade on 12/27/2017.
 */

public interface IUserInterfaceView extends MakePaymentFragment.OnFragmentInteractionListener {

    /**
     * @param message shown to user
     */
    void showMessageToUser(String message);

    /**
     * @param bill to be shown to user to pay
     */
    void totalBillForQuantity(String bill);

    /**
     * @param quantity number of product selected
     */
    void quantityOfProduct(String quantity);

    /**
     * @param currency is a instance of {@link Currency} denoting how much user needs to pay
     */
    void showFragment(Currency currency);
}
