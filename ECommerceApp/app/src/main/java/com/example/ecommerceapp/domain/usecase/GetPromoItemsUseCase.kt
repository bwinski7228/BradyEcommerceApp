package com.example.ecommerceapp.domain.usecase

import com.example.ecommerceapp.data.model.APIResponse
import com.example.ecommerceapp.data.util.Resource
import com.example.ecommerceapp.domain.repository.ShopRepository

class GetPromoItemsUseCase(private val shopRepository: ShopRepository) {

    suspend fun execute(): Resource<APIResponse> {
        return shopRepository.getPromoItems()
    }
}