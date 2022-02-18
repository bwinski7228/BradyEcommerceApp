package com.example.ecommerceapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.example.ecommerceapp.data.model.APIResponse
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.model.User
import com.example.ecommerceapp.data.util.Resource
import com.example.ecommerceapp.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(
    val app:Application,
    val getItemsUseCase: GetItemsUseCase,
    val getPromoItemsUseCase: GetPromoItemsUseCase,
    val addItemToCartUseCase: AddItemToCartUseCase,
    val getCartUseCase: GetCartUseCase,
    val deleteItemInCartUseCase: DeleteItemInCartUseCase,
    val clearCartUseCase: ClearCartUseCase,
    val addUserUseCase: AddUserUseCase,
    val getUsersUseCase: GetUsersUseCase
    ) : AndroidViewModel(app) {

    val shopItems: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    val promoItems: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    val description = MutableLiveData<String>()

    init {
        description.value = "Two-way data binding is fun!"
    }

    fun getShopItems() = viewModelScope.launch(Dispatchers.IO) {
        shopItems.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {

                val apiResult = getItemsUseCase.execute()
                shopItems.postValue(apiResult)
            } else {
                shopItems.postValue(Resource.Error("Internet is not available"))
            }
        } catch (e:Exception) {
            shopItems.postValue(Resource.Error(e.message.toString()))
        }
    }

    fun getPromoItems() = viewModelScope.launch(Dispatchers.IO) {
        promoItems.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {

                val apiResult = getPromoItemsUseCase.execute()
                promoItems.postValue(apiResult)
            } else {
                promoItems.postValue(Resource.Error("Internet is not available"))
            }
        } catch (e:Exception) {
            promoItems.postValue(Resource.Error(e.message.toString()))
        }
    }

    private fun isNetworkAvailable(context: Context?):Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }

    fun addItemToList(shopItem: ShopItem) = viewModelScope.launch {
        addItemToCartUseCase.execute(shopItem)
    }

    fun getCart() = liveData {
        getCartUseCase.execute().collect {
            emit(it)
        }
    }

    fun deleteShopItem(shopItem: ShopItem) = viewModelScope.launch {
        deleteItemInCartUseCase.execute(shopItem)
    }

    fun clearCart() = viewModelScope.launch {
        clearCartUseCase.execute()
    }

    fun addUserToList(user: User) = viewModelScope.launch {
        addUserUseCase.execute(user)
    }

    fun getUsers() : List<User> {
        return getUsersUseCase.execute()
    }

}