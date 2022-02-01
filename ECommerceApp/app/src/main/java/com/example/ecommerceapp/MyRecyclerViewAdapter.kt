package com.example.ecommerceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MyRecyclerViewAdapter(private val BeveragesList:List<Beverage>, private val clickListener:(Beverage)->Unit): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(BeveragesList[position], clickListener)
    }

}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(Beverage: Beverage, clickListener:(Beverage)->Unit) {
        view.name_text_view.text = Beverage.brand
        view.setOnClickListener{
            clickListener(Beverage)
        }
    }
}