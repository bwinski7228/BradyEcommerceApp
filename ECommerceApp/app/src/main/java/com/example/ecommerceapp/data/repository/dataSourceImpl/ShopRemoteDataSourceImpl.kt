package com.example.ecommerceapp.data.repository.dataSourceImpl

import com.example.ecommerceapp.data.api.ShopAPIService
import com.example.ecommerceapp.data.model.APIResponse
import com.example.ecommerceapp.data.repository.dataSource.ShopRemoteDataSource
import retrofit2.Response
import java.util.*

class ShopRemoteDataSourceImpl(
    private val shopAPIService: ShopAPIService

): ShopRemoteDataSource {
    override suspend fun getItems(): Response<APIResponse> {
        return shopAPIService.getItems()
    }

    override suspend fun getPromoItems(): Response<APIResponse> {
        return shopAPIService.getPromoItems()
    }

}