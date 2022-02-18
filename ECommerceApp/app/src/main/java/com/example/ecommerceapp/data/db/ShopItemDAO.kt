package com.example.ecommerceapp.data.db

import androidx.room.*
import com.example.ecommerceapp.data.model.ShopItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopItemDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(shopItem: ShopItem)

    @Query("SELECT * FROM shopItems")
    fun getShopItems(): Flow<List<ShopItem>>

    @Delete
    suspend fun deleteShopItem(shopItem: ShopItem)

    @Query("DELETE FROM shopItems")
    suspend fun clearCart()
}