package com.example.ecommerceapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.ecommerceapp.data.db.ShopItemDAO
import com.example.ecommerceapp.data.db.ShopItemDatabase
import com.example.ecommerceapp.data.db.UserDAO
import com.example.ecommerceapp.data.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideShopItemDatabase(app: Application):ShopItemDatabase{
        return Room.databaseBuilder(app, ShopItemDatabase::class.java, "cart_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideShopItemDao(shopItemDatabase: ShopItemDatabase):ShopItemDAO{
        return shopItemDatabase.getShopItemDAO()
    }

    @Singleton
    @Provides
    fun provideUserDatabase(app: Application):UserDatabase{
        return Room.databaseBuilder(app, UserDatabase::class.java, "user_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(userDatabase: UserDatabase): UserDAO {
        return userDatabase.getUserDAO()
    }
}