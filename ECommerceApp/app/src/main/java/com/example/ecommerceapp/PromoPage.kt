package com.example.ecommerceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.promo_page.*

class PromoPage: Fragment(R.layout.promo_page) {
    val PromoList = listOf(
        Beverage("Sprite", "Sprite", "Coca-Cola", .99, R.drawable.sprite, true),
        Beverage("Mountain Dew", "Mountain Dew Baja Blast", "Pepsi", 1.49, R.drawable.baja_blast, true),
        Beverage("Mountain Dew", "Mountain Dew Code Red", "Pepsi", 1.99, R.drawable.code_red, true),
    )


    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<PromoViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.promo_page, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        promo_recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = PromoRecyclerViewAdapter(PromoList, { selectedBeverageItem: Beverage -> listItemClicked(selectedBeverageItem) })
        }
    }

    private fun listItemClicked(Beverage: Beverage) {
        Toast.makeText(
            activity,
            "${Beverage.name} has been added to your cart", Toast.LENGTH_LONG
        ).show()
    }
}