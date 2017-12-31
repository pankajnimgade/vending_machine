package com.nimgade.pk.vendingmachine.application.repository

import android.support.annotation.NonNull
import com.nimgade.pk.vendingmachine.application.model.product.Product
import com.nimgade.pk.vendingmachine.application.model.product.ProductCreator
import javax.inject.Inject

/**
 * Created by Pankaj Nimgade on 12/26/2017.
 */
class MemoryInStockInventory : Inventory {

    private val productsHashMap = HashMap<Int, MutableList<Product>>()

    init {
        for (currentProduct in ProductCreator.initialize()) {
            addProductToInventory(currentProduct)
        }
    }

    @Inject
    constructor()

    override fun getListOfProducts(productType: Int): MutableList<Product> {
        return productsHashMap.get(productType) ?: mutableListOf()
    }

    override fun addProductToInventory(@NonNull currentProduct: Product) {
        var productList = productsHashMap.get(currentProduct.productType)
        if (productList != null) {
            productList.add(currentProduct)
        } else {
            productList = mutableListOf()
            productList.add(currentProduct)
            productsHashMap.put(currentProduct.productType, productList)
        }
    }

    override fun removeProductFromInventory(productType: Int): Product? {
        val mutableList = productsHashMap.get(productType)
        if (mutableList != null) {
            if (mutableList.isNotEmpty()) {
                return mutableList.removeAt(0)
            }
        }
        return null
    }
}