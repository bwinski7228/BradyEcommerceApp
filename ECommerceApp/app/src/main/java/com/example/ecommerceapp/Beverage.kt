package com.example.ecommerceapp

import android.graphics.drawable.Drawable

data class Beverage(val brand:String, val name:String, val producer:String, var price:Double, val image:Int, val promo:Boolean = false)