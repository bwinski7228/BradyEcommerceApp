package com.example.ecommerceapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class PromoRecyclerViewAdapter(private val BeveragesList:List<Beverage>, private val clickListener:(Beverage)->Unit): RecyclerView.Adapter<PromoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return PromoViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(BeveragesList[position], clickListener)
    }

}

class PromoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(Beverage: Beverage, clickListener:(Beverage)->Unit) {
        view.name_text_view.text = Beverage.name
        view.text_view_price.text = "$" + Beverage.price.toString()
        view.image_view_project_icon.setImageResource(Beverage.image)
        view.button_add_to_cart.setOnClickListener{
            clickListener(Beverage)
        }
        if (Beverage.promo) {
            view.text_view_price.setTextColor(Color.parseColor("#F44336"))
        }
    }
}