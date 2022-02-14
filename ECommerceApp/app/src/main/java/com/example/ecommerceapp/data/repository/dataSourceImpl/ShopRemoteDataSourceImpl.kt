package com.example.ecommerceapp.data.repository.dataSourceImpl

import com.example.ecommerceapp.data.api.ShopAPIService
import com.example.ecommerceapp.data.model.APIResponse
import com.example.ecommerceapp.data.repository.dataSource.ShopRemoteDataSource
import retrofit2.Response
import java.util.*

class ShopRemoteDataSourceImpl(
    private val shopAPIService: ShopAPIService
/*    private val id: Int,
    private val title: String,
    private val price: String,
    private val description: String,
    private val image: String*/
): ShopRemoteDataSource {
    override suspend fun getItems(): Response<APIResponse> {
        return shopAPIService.getItems(/*id, title, price, description, image*/)
    }

}