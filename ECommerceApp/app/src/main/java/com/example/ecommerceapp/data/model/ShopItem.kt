package com.example.ecommerceapp.data.model

import com.google.gson.annotations.SerializedName

data class ShopItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String,
    val urlToImage: String?
)