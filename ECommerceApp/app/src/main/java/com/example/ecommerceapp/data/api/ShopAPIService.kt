package com.example.ecommerceapp.data.api

import com.example.ecommerceapp.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopAPIService {

    @GET("/products")
    suspend fun getItems(
    ): Response<APIResponse>

    @GET("/products/category/electronics")
    suspend fun getPromoItems(
    ): Response<APIResponse>
}