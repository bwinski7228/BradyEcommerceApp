package com.example.ecommerceapp.presentation.di

import com.example.ecommerceapp.data.api.ShopAPIService
import com.example.ecommerceapp.data.repository.dataSource.ShopRemoteDataSource
import com.example.ecommerceapp.data.repository.dataSourceImpl.ShopRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideShopRemoteDataSource(shopAPIService: ShopAPIService): ShopRemoteDataSource {
        return ShopRemoteDataSourceImpl(shopAPIService)
    }
}