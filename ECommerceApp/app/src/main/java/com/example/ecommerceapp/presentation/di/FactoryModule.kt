package com.example.ecommerceapp.presentation.di

import android.app.Application
import com.example.ecommerceapp.domain.usecase.GetItemsUseCase
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
        getItemsUseCase: GetItemsUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            application,
            getItemsUseCase
        )
    }
}