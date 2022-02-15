package com.example.ecommerceapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.*
import com.example.ecommerceapp.Beverage
import com.example.ecommerceapp.R
import com.example.ecommerceapp.data.model.APIResponse
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.util.Resource
import com.example.ecommerceapp.domain.usecase.AddItemToCartUseCase
import com.example.ecommerceapp.domain.usecase.GetCartUseCase
import com.example.ecommerceapp.domain.usecase.GetItemsUseCase
import com.example.ecommerceapp.domain.usecase.GetPromoItemsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(/*startingCart : MutableList<Beverage>,*/
    val app:Application,
    val getItemsUseCase: GetItemsUseCase,
    val getPromoItemsUseCase: GetPromoItemsUseCase,
    val addItemToCartUseCase: AddItemToCartUseCase,
    val getCartUseCase: GetCartUseCase
    ) : AndroidViewModel(app) {

    val shopItems: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    val promoItems: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getShopItems() = viewModelScope.launch(Dispatchers.IO) {
        shopItems.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {

                val apiResult = getItemsUseCase.execute()
                shopItems.postValue(apiResult)
                println("shopitemsbooga: " + shopItems.value)
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
                println("promoitemsbooga: " + promoItems.value)
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


    val cartList = MutableLiveData<MutableList<Beverage>>()
    val cartListData : LiveData<MutableList<Beverage>>
    get() = cartList

    val bevList = MutableLiveData<MutableList<Beverage>>()
    val bevListData : LiveData<MutableList<Beverage>>
    get() = bevList

    init {
        //cartList.value = startingCart
        bevList.value = mutableListOf(
            Beverage("Coke", "Coke Classic", "Coca-Cola", .99, R.drawable.coke_can),
            Beverage("Coke", "Vanilla Coke", "Coca-Cola", 1.49, R.drawable.coca_cola_vanilla ),
            Beverage("Coke", "Cherry Coke", "Coca-Cola", 1.99, R.drawable.cherry_coke),
            Beverage("Sprite", "Sprite", "Coca-Cola", .99, R.drawable.sprite, true),
            Beverage("Mountain Dew", "Mountain Dew", "Pepsi", .99, R.drawable.mtn_dew),
            Beverage("Mountain Dew", "Mountain Dew Baja Blast", "Pepsi", 1.49, R.drawable.baja_blast, true),
            Beverage("Mountain Dew", "Mountain Dew Code Red", "Pepsi", 1.99, R.drawable.code_red, true),
        )
    }

    fun addItemToList(shopItem: ShopItem) = viewModelScope.launch {
        addItemToCartUseCase.execute(shopItem)
    }

    fun getCart() = liveData {
        getCartUseCase.execute().collect {
            emit(it)
        }
    }

}