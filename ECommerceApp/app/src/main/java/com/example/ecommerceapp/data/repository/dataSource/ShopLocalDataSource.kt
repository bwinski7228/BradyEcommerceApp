package com.example.ecommerceapp.data.repository.dataSource

import com.example.ecommerceapp.data.model.ShopItem
import kotlinx.coroutines.flow.Flow

interface ShopLocalDataSource {
    suspend fun saveShopItemToDB(shopItem: ShopItem)
    fun getCart(): Flow<List<ShopItem>>
}