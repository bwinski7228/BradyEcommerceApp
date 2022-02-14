package com.example.ecommerceapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ecommerceapp.Beverage
import com.example.ecommerceapp.domain.usecase.GetItemsUseCase
import java.lang.IllegalArgumentException

class MainViewModelFactory(/*private val startingCart : MutableList<Beverage>*/ private val app: Application, private val getItemsUseCase: GetItemsUseCase) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(app, getItemsUseCase) as T
    }

}