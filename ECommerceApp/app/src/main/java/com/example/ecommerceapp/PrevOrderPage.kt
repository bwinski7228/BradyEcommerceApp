package com.example.ecommerceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceapp.data.model.Rating
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.old.Beverage
import kotlinx.android.synthetic.main.prev_order_page.*

class PrevOrderPage: AppCompatActivity() {

    val rating = Rating(1,1.0)

    val orderList1 = listOf(
        ShopItem(1, "", "", 1, "", 22.2, rating, "Mens Casual Premium Slim Fit T-Shirts", false),
        ShopItem(1, "", "", 1, "", 22.2, rating, "Mens Cotton Jacket", false),
        ShopItem(1, "", "", 1, "", 22.2, rating, "Mens Casual Slim Fit", false)
    )

    val orderList2 = listOf(
        ShopItem(1, "", "", 1, "", 22.2, rating, "Solid Gold Petite Mircopave", false),
        ShopItem(1, "", "", 1, "", 22.2, rating, "White Gold Plated Princess", false),
        ShopItem(1, "", "", 1, "", 22.2, rating, "Mens Casual Premium Slim Fit T-Shirts", false)
    )

    val orderList3 = listOf(
        ShopItem(1, "", "", 1, "", 22.2, rating, "Solid Gold Petite Mircopave", false),
        ShopItem(1, "", "", 1, "", 22.2, rating, "Mens Casual Premium Slim Fit T-Shirts", false),
        ShopItem(1, "", "", 1, "", 22.2, rating, "Mens Cotton Jacket", false)
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