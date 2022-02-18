package com.example.ecommerceapp.domain.usecase


import com.example.ecommerceapp.data.model.User
import com.example.ecommerceapp.domain.repository.ShopRepository
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(private val shopRepository: ShopRepository) {
    fun execute(): List<User> {
        return shopRepository.getUsers()
    }
}