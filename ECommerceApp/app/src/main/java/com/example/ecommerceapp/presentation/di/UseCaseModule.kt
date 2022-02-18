package com.example.ecommerceapp.presentation.di

import com.example.ecommerceapp.data.repository.ShopRepositoryImpl
import com.example.ecommerceapp.data.repository.dataSource.ShopRemoteDataSource
import com.example.ecommerceapp.domain.repository.ShopRepository
import com.example.ecommerceapp.domain.usecase.*
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
    @Singleton
    @Provides
    fun provideGetPromoItemsUseCase(
        shopRepository: ShopRepository
    ) : GetPromoItemsUseCase {
        return GetPromoItemsUseCase(shopRepository)
    }

    @Singleton
    @Provides
    fun provideAddItemToCartUseCase(
        shopRepository: ShopRepository
    ) : AddItemToCartUseCase {
        return AddItemToCartUseCase(shopRepository)
    }

    @Singleton
    @Provides
    fun provideGetCartUseCase(
        shopRepository: ShopRepository
    ) : GetCartUseCase {
        return GetCartUseCase(shopRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteItemInCartUseCase(
        shopRepository: ShopRepository
    ) : DeleteItemInCartUseCase {
        return DeleteItemInCartUseCase(shopRepository)
    }

    @Singleton
    @Provides
    fun provideClearCartUseCase(
        shopRepository: ShopRepository
    ) : ClearCartUseCase {
        return ClearCartUseCase(shopRepository)
    }

    @Singleton
    @Provides
    fun provideAddUserUseCase(
        shopRepository: ShopRepository
    ) : AddUserUseCase {
        return AddUserUseCase(shopRepository)
    }

    @Singleton
    @Provides
    fun provideGetUsersUseCase(
        shopRepository: ShopRepository
    ) : GetUsersUseCase {
        return GetUsersUseCase(shopRepository)
    }
}