package com.example.ecommerceapp.data.repository.dataSourceImpl

import com.example.ecommerceapp.data.db.ShopItemDAO
import com.example.ecommerceapp.data.db.UserDAO
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.model.User
import com.example.ecommerceapp.data.repository.dataSource.ShopLocalDataSource
import kotlinx.coroutines.flow.Flow

class ShopLocalDataSourceImpl(
    private val shopItemDAO: ShopItemDAO,
    private val userDAO: UserDAO
) : ShopLocalDataSource{
    override suspend fun saveShopItemToDB(shopItem: ShopItem) {
        shopItemDAO.insert(shopItem)
    }

    override fun getCart(): Flow<List<ShopItem>> {
        return shopItemDAO.getShopItems()
    }

    override suspend fun deleteShopItemFromDB(shopItem: ShopItem) {
        shopItemDAO.deleteShopItem(shopItem)
    }

    override suspend fun clearCart() {
        shopItemDAO.clearCart()
    }

    override suspend fun saveUserToDB(user: User) {
        userDAO.insert(user)
    }

    override fun getUsers(): MutableList<User> {
        return userDAO.getUsers()
    }

}