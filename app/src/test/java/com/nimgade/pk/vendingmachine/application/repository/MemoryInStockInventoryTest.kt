package com.nimgade.pk.vendingmachine.application.repository

import com.nimgade.pk.vendingmachine.application.dagger.DaggerRepositoriesComponent
import com.nimgade.pk.vendingmachine.application.model.product.ProductCreator
import com.nimgade.pk.vendingmachine.application.model.product.ProductItem
import org.junit.Test

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */
class MemoryInStockInventoryTest {


    @Test
    fun checkMemoryInventory() {
        val inventory = DaggerRepositoriesComponent.create().inventory
        for (product in ProductCreator.initialize()) {
            inventory.addProductToInventory(product)
        }
        for (index in 1..10) {
            val listOfProducts = inventory.getListOfProducts(index)
            if (listOfProducts.isNotEmpty()) {
                println(listOfProducts.size)
                for (product in listOfProducts) {
                    println(product)
                }
            }
            println("\n###########\n")
        }
    }


}