package com.example.ecommerceapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prev_order_item.view.*

class PrevOrderViewAdapter(private val OrdersList:List<List<Beverage>>): RecyclerView.Adapter<PrevOrderViewHolder>() {

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

    fun bind(prevOrder: List<Beverage>) {
        var orderString = ""
        for (order in prevOrder) {
            if (orderString == "") {
                orderString = orderString + order.name
            } else {
                orderString = orderString + ", " + order.name
            }
        }
        view.text_view_prev_items.text = orderString
    }
}