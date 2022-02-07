package com.example.ecommerceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.prev_order_page.*

class PrevOrderPage: AppCompatActivity() {

    val orderList1 = listOf(
        Beverage("Coke", "Coke Classic", "Coca-Cola", .99, R.drawable.coke_can),
        Beverage("Sprite", "Sprite", "Coca-Cola", .49, R.drawable.sprite, true),
        Beverage("Mountain Dew", "Mountain Dew", "Pepsi", .99, R.drawable.mtn_dew),
    )

    val orderList2 = listOf(
        Beverage("Coke", "Vanilla Coke", "Coca-Cola", 1.49, R.drawable.coca_cola_vanilla),
        Beverage("Mountain Dew", "Mountain Dew Baja Blast", "Pepsi", .99, R.drawable.baja_blast, true),
    )

    val orderList3 = listOf(
        Beverage("Coke", "Coke Classic", "Coca-Cola", .99, R.drawable.coke_can),
        Beverage("Coke", "Vanilla Coke", "Coca-Cola", 1.49, R.drawable.coca_cola_vanilla),
        Beverage("Mountain Dew", "Mountain Dew Baja Blast", "Pepsi", .99, R.drawable.baja_blast, true),
        Beverage("Sprite", "Sprite", "Coca-Cola", .49, R.drawable.sprite, true),
        Beverage("Mountain Dew", "Mountain Dew", "Pepsi", .99, R.drawable.mtn_dew),
    )

    val prevOrderList = listOf(orderList1, orderList2, orderList3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.prev_order_page)

        prev_orders_recycler_view.layoutManager = LinearLayoutManager(this)
        // set the custom adapter to the RecyclerView
        prev_orders_recycler_view.adapter = PrevOrderViewAdapter(prevOrderList)
    }
}