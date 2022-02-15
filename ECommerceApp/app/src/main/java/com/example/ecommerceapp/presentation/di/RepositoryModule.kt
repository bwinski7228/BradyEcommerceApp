package com.example.ecommerceapp.presentation.di

import com.example.ecommerceapp.data.repository.ShopRepositoryImpl
import com.example.ecommerceapp.data.repository.dataSource.ShopLocalDataSource
import com.example.ecommerceapp.data.repository.dataSource.ShopRemoteDataSource
import com.example.ecommerceapp.domain.repository.ShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideShopRepository(
        shopRemoteDataSource: ShopRemoteDataSource,
        shopLocalDataSource: ShopLocalDataSource
    ) : ShopRepository {
        return ShopRepositoryImpl(shopRemoteDataSource, shopLocalDataSource)
    }
}