package com.nimgade.pk.vendingmachine.activities.user.interaction.view;

import com.nimgade.pk.vendingmachine.application.model.Currency;

/**
 * Created by Pankaj Nimgade on 12/27/2017.
 */

public interface IUserInterfaceView extends MakePaymentFragment.OnFragmentInteractionListener {

    void showMessageToUser(String message);

    void totalBillForQuantity(String bill);

    void quantityOfProduct(String quantity);

    void showFragment(Currency currency);
}
