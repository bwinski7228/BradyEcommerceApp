package com.example.ecommerceapp.data.repository.dataSourceImpl

import com.example.ecommerceapp.data.db.ShopItemDAO
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.repository.dataSource.ShopLocalDataSource
import kotlinx.coroutines.flow.Flow

class ShopLocalDataSourceImpl(
    private val shopItemDAO: ShopItemDAO
) : ShopLocalDataSource{
    override suspend fun saveShopItemToDB(shopItem: ShopItem) {
        shopItemDAO.insert(shopItem)
    }

    override fun getCart(): Flow<List<ShopItem>> {
        return shopItemDAO.getShopItems()
    }

}