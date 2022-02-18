package com.example.ecommerceapp.data.repository.dataSource

import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.model.User
import kotlinx.coroutines.flow.Flow

interface ShopLocalDataSource {
    suspend fun saveShopItemToDB(shopItem: ShopItem)
    fun getCart(): Flow<List<ShopItem>>
    suspend fun deleteShopItemFromDB(shopItem: ShopItem)
    suspend fun clearCart()
    suspend fun saveUserToDB(user: User)
    fun getUsers(): MutableList<User>
}