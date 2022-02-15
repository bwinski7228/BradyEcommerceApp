package com.example.ecommerceapp.presentation.di

import com.example.ecommerceapp.data.db.ShopItemDAO
import com.example.ecommerceapp.data.repository.dataSource.ShopLocalDataSource
import com.example.ecommerceapp.data.repository.dataSourceImpl.ShopLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(shopItemDAO: ShopItemDAO): ShopLocalDataSource {
        return ShopLocalDataSourceImpl(shopItemDAO)
    }
}