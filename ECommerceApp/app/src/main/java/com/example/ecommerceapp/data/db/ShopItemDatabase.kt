package com.example.ecommerceapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.ecommerceapp.data.model.ShopItem

@Database(
    entities = [ShopItem::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ShopItemDatabase : RoomDatabase() {
    abstract fun getShopItemDAO():ShopItemDAO
}