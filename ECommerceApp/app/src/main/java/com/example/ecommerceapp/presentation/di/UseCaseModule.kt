package com.example.ecommerceapp.presentation.di

import com.example.ecommerceapp.data.repository.ShopRepositoryImpl
import com.example.ecommerceapp.data.repository.dataSource.ShopRemoteDataSource
import com.example.ecommerceapp.domain.repository.ShopRepository
import com.example.ecommerceapp.domain.usecase.GetItemsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetItemsUseCase(
        shopRepository: ShopRepository
    ) : GetItemsUseCase {
        return GetItemsUseCase(shopRepository)
    }
}