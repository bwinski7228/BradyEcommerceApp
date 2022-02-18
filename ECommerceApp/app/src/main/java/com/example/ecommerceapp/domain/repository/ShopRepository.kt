package com.example.ecommerceapp.domain.repository

import com.example.ecommerceapp.data.model.APIResponse
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.model.User
import com.example.ecommerceapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface ShopRepository {

    suspend fun getItems(): Resource<APIResponse>

    suspend fun getPromoItems(): Resource<APIResponse>

    suspend fun addItemToCart(shopItem: ShopItem)

    suspend fun deleteItemInCart(shopItem: ShopItem)

    fun getCart(): Flow<List<ShopItem>>

    suspend fun clearCart()

    suspend fun addUser(user: User)

    fun getUsers(): MutableList<User>
}