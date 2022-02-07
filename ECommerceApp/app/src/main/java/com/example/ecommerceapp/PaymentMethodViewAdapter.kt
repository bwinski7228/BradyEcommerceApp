package com.example.ecommerceapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.payment_method_item.view.*

class PaymentMethodViewAdapter(private val MethodsList:List<PaymentMethod>): RecyclerView.Adapter<PaymentMethodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.payment_method_item, parent, false)
        return PaymentMethodViewHolder(listItem)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: PaymentMethodViewHolder, position: Int) {
        holder.bind(MethodsList[position])
    }

}

class PaymentMethodViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(PaymentMethod: PaymentMethod) {
        view.text_view_method_digits.text = "Ends in: " + PaymentMethod.digits
        view.image_view_method_icon.setImageResource(PaymentMethod.logo)
    }
}