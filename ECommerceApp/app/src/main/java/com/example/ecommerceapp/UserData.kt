package com.example.ecommerceapp

import android.graphics.drawable.Drawable
import androidx.room.TypeConverters

data class UserData(
    var name: String,
    var email: String,
    var proPic: Int
)