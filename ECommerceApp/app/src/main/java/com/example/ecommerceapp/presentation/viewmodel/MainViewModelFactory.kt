package com.example.ecommerceapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceapp.domain.usecase.*

class MainViewModelFactory(private val app: Application,
                           private val getItemsUseCase: GetItemsUseCase,
                           private val getPromoItemsUseCase: GetPromoItemsUseCase,
                           private val addItemToCartUseCase: AddItemToCartUseCase,
                            private val getCartUseCase: GetCartUseCase,
                            private val deleteItemInCartUseCase: DeleteItemInCartUseCase,
                            private val clearCartUseCase: ClearCartUseCase,
                            private val addUserUseCase: AddUserUseCase,
                           private val getUsersUseCase: GetUsersUseCase
                           ) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(app, getItemsUseCase, getPromoItemsUseCase, addItemToCartUseCase, getCartUseCase, deleteItemInCartUseCase, clearCartUseCase, addUserUseCase, getUsersUseCase) as T
    }

}