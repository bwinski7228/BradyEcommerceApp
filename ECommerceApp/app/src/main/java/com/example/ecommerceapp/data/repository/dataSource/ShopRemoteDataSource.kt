package com.example.ecommerceapp.data.repository.dataSource

import com.example.ecommerceapp.data.model.APIResponse
import retrofit2.Response

interface ShopRemoteDataSource {
    suspend fun getItems():Response<APIResponse>
    suspend fun getPromoItems():Response<APIResponse>
}