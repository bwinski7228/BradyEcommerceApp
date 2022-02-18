package com.example.ecommerceapp.presentation.di

import android.app.Application
import com.example.ecommerceapp.domain.usecase.*
import com.example.ecommerceapp.presentation.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class FactoryModule {
    @Singleton
    @Provides
    fun provideMainViewModelFactory(
        application: Application,
        getItemsUseCase: GetItemsUseCase,
        getPromoItemsUseCase: GetPromoItemsUseCase,
        addItemToCartUseCase: AddItemToCartUseCase,
        getCartUseCase: GetCartUseCase,
        deleteItemInCartUseCase: DeleteItemInCartUseCase,
        clearCartUseCase: ClearCartUseCase,
        addUserUseCase: AddUserUseCase,
        getUsersUseCase: GetUsersUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            application,
            getItemsUseCase,
            getPromoItemsUseCase,
            addItemToCartUseCase,
            getCartUseCase,
            deleteItemInCartUseCase,
            clearCartUseCase,
            addUserUseCase,
            getUsersUseCase
        )
    }
}