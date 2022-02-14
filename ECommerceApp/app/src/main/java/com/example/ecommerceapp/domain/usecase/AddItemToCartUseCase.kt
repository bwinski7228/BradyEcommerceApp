package com.example.ecommerceapp.domain.usecase

import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.domain.repository.ShopRepository

class AddItemToCartUseCase(private val shopRepository: ShopRepository) {

    suspend fun execute(shopItem: ShopItem) = shopRepository.addItemToCart(shopItem)
}