package com.example.ecommerceapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ecommerceapp.data.model.ShopItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopItemDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(shopItem: ShopItem)

    @Query("SELECT * FROM shopItems")
    fun getShopItems(): Flow<List<ShopItem>>
}