package com.example.ecommerceapp.domain.repository

import com.example.ecommerceapp.data.model.APIResponse
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface ShopRepository {

    suspend fun getItems(): Resource<APIResponse>

    suspend fun addItemToCart(shopItem: ShopItem)

    suspend fun deleteItemInCart(shopItem: ShopItem)

    fun getCart(): Flow<List<ShopItem>>
}