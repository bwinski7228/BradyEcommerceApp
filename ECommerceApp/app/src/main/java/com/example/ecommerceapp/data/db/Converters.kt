package com.example.ecommerceapp.data.db

import androidx.room.TypeConverter
import com.example.ecommerceapp.data.model.Rating


class Converters {
    @TypeConverter
    fun fromRating(rating: Rating):Double {
        return rating.rate
    }
    @TypeConverter
    fun toRating(rate:Double):Rating{
        return Rating(rate.toInt(), rate)
    }

}