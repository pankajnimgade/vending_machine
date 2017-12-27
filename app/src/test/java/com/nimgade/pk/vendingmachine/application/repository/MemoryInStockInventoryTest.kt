package com.nimgade.pk.vendingmachine.application.repository

import com.nimgade.pk.vendingmachine.application.dagger.DaggerResositoryComponent
import com.nimgade.pk.vendingmachine.application.model.ProductItem
import org.junit.Test
import java.util.*

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */
class MemoryInStockInventoryTest {


    @Test
    fun checkMemoryInventory() {
        val inventory = DaggerRepositoriesComponent.create().inventory

        for (index in 1..100) {
            val product = ProductItem("Name# $index", Random().nextDouble() * 100, Random().nextInt(10) + 1)
            inventory.addProductToInventory(product)
        }

        for (index in 1..10) {
            val listOfProducts = inventory.getListOfProducts(index)
            if (listOfProducts.isNotEmpty()) {
                println(listOfProducts.size)
                for (product in listOfProducts){
                    println(product)
                }
            }
            println("\n###########\n")
        }


    }
}