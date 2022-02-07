package com.example.ecommerceapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.android.synthetic.main.list_item_cart.view.*

class CartPageViewAdapter(private val BeveragesList:List<Beverage>): RecyclerView.Adapter<CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item_cart, parent, false)
        return CartViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(BeveragesList[position])
    }

}

class CartViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(Beverage: Beverage) {
        view.cart_name_text_view.text = Beverage.name
        view.cart_text_view_price.text = "$" + Beverage.price.toString()
        view.cart_image_view_project_icon.setImageResource(Beverage.image)
        if (Beverage.promo) {
            view.cart_text_view_price.setTextColor(Color.parseColor("#F44336"))
        }
    }
}