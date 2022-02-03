package com.example.ecommerceapp

import androidx.room.TypeConverters

data class UserData(
    var name: String = "",
    var email: String = "",
    var cart: List<Beverage> = ArrayList(),
)