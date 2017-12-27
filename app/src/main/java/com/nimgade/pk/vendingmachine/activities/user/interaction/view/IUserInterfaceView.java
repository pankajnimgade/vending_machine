package com.nimgade.pk.vendingmachine.activities.user.interaction.view;

/**
 * Created by Pankaj Nimgade on 12/27/2017.
 */

public interface IUserInterfaceView {

    void showMessageToUser(String message);

    void totalBillForQuantity(String bill);

    void quantityOfProduct(String quantity);
}
