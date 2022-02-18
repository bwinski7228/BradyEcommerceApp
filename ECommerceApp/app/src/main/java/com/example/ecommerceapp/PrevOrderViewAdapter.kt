package com.example.ecommerceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.old.Beverage
import kotlinx.android.synthetic.main.prev_order_item.view.*

class PrevOrderViewAdapter(private val OrdersList:List<List<ShopItem>>): RecyclerView.Adapter<PrevOrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrevOrderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.prev_order_item, parent, false)
        return PrevOrderViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: PrevOrderViewHolder, position: Int) {
        holder.bind(OrdersList[position])
    }

}

class PrevOrderViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(prevOrder: List<ShopItem>) {
        var orderString = ""
        for (order in prevOrder) {
            if (orderString == "") {
                orderString = orderString + order.title
            } else {
                orderString = orderString + ", " + order.title
            }
        }
        view.text_view_prev_items.text = orderString
    }
}