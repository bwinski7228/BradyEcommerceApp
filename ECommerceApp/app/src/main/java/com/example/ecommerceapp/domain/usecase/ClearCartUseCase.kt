package com.example.ecommerceapp.domain.usecase

import com.example.ecommerceapp.domain.repository.ShopRepository

class ClearCartUseCase(private val shopRepository: ShopRepository) {

    suspend fun execute() = shopRepository.clearCart()
}