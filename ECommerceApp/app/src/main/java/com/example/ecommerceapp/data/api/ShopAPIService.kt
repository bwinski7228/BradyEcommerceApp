package com.example.ecommerceapp.data.api

import com.example.ecommerceapp.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopAPIService {

    @GET("/products")
    suspend fun getItems(
        /*@Query("id")
        id: Int?,
        @Query("title")
        title: String?,
        @Query("price")
        price: String?,
        @Query("description")
        description: String?,
        @Query("image")
        image: String?*/
    ): Response<APIResponse>
}