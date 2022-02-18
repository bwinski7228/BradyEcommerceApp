package com.example.ecommerceapp.data.repository

import com.example.ecommerceapp.data.model.APIResponse
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.model.User
import com.example.ecommerceapp.data.repository.dataSource.ShopLocalDataSource
import com.example.ecommerceapp.data.repository.dataSource.ShopRemoteDataSource
import com.example.ecommerceapp.data.util.Resource
import com.example.ecommerceapp.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class ShopRepositoryImpl(
    private val shopRemoteDataSource: ShopRemoteDataSource,
    private val shopLocalDataSource: ShopLocalDataSource
): ShopRepository {
    override suspend fun getItems(): Resource<APIResponse> {
        return responseToResource(shopRemoteDataSource.getItems())
    }

    override suspend fun getPromoItems(): Resource<APIResponse> {
        return responseToResource(shopRemoteDataSource.getPromoItems())
    }

    private fun responseToResource(response:Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
             response.body()?.let {result ->
                 return Resource.Success(result)
             }
        }
        return Resource.Error(response.message())
    }

    override suspend fun addItemToCart(shopItem: ShopItem) {
        shopLocalDataSource.saveShopItemToDB(shopItem)
    }

    override suspend fun deleteItemInCart(shopItem: ShopItem) {
        shopLocalDataSource.deleteShopItemFromDB(shopItem)
    }

    override fun getCart(): Flow<List<ShopItem>> {
        return shopLocalDataSource.getCart()
    }

    override suspend fun clearCart() {
        return shopLocalDataSource.clearCart()
    }

    override suspend fun addUser(user: User) {
        return shopLocalDataSource.saveUserToDB(user)
    }

    override fun getUsers(): MutableList<User> {
        return shopLocalDataSource.getUsers()
    }
}