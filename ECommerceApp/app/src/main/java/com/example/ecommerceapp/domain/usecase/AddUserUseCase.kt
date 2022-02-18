package com.example.ecommerceapp.domain.usecase

import com.example.ecommerceapp.data.model.User
import com.example.ecommerceapp.domain.repository.ShopRepository

class AddUserUseCase (private val shopRepository: ShopRepository) {

    suspend fun execute(user: User) = shopRepository.addUser(user)
}