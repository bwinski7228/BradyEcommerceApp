package com.example.ecommerceapp.domain.usecase

import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow

class GetCartUseCase(private val shopRepository: ShopRepository) {
    fun execute(): Flow<List<ShopItem>> {
        return shopRepository.getCart()
    }
}