package com.example.ecommerceapp.data.repository.shopItem

import com.example.ecommerceapp.api.ShopAPIServiceTest
import com.example.ecommerceapp.data.model.APIResponse
import com.example.ecommerceapp.data.model.Rating
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.model.User
import com.example.ecommerceapp.data.util.Resource
import com.example.ecommerceapp.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf

class FakeShopRepository: ShopRepository {

    private var cart = flowOf(mutableListOf<ShopItem>())

    init {
        val rating = Rating(1,1.0)
        cart = flowOf(mutableListOf((ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)), ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false)))
    }

    override suspend fun getItems(): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getPromoItems(): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun addItemToCart(shopItem: ShopItem) {
        var oldCart = cart.first()
        oldCart.add(shopItem)
        cart = flowOf(oldCart)
    }

    override suspend fun deleteItemInCart(shopItem: ShopItem) {
        var oldCart = cart.first()
        oldCart.remove(shopItem)
        cart = flowOf(oldCart)
    }

    override fun getCart(): Flow<List<ShopItem>> {
        return cart
    }

    override suspend fun clearCart() {
        cart = flowOf(mutableListOf<ShopItem>())
    }

    override suspend fun addUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun getUsers(): MutableList<User> {
        TODO("Not yet implemented")
    }
}