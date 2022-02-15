package com.example.ecommerceapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceapp.Beverage
import com.example.ecommerceapp.domain.usecase.AddItemToCartUseCase
import com.example.ecommerceapp.domain.usecase.GetCartUseCase
import com.example.ecommerceapp.domain.usecase.GetItemsUseCase
import com.example.ecommerceapp.domain.usecase.GetPromoItemsUseCase
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val app: Application,
                           private val getItemsUseCase: GetItemsUseCase,
                           private val getPromoItemsUseCase: GetPromoItemsUseCase,
                           private val addItemToCartUseCase: AddItemToCartUseCase,
                            private val getCartUseCase: GetCartUseCase) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(app, getItemsUseCase, getPromoItemsUseCase, addItemToCartUseCase, getCartUseCase) as T
    }

}