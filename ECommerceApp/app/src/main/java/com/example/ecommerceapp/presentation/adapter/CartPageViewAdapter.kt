package com.example.ecommerceapp.presentation.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.databinding.ListItemBinding
import com.example.ecommerceapp.databinding.ListItemCartBinding
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.android.synthetic.main.list_item_cart.view.*

class CartPageViewAdapter(private val clickListener:(ShopItem)->Unit): RecyclerView.Adapter<CartViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<ShopItem>() {
        override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ListItemCartBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val shopItem = differ.currentList[position]
        holder.bind(shopItem, clickListener)
    }

}

class CartViewHolder(val binding : ListItemCartBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(shopItem: ShopItem, clickListener:(ShopItem)->Unit) {
        binding.cartNameTextView.text = shopItem.title
        binding.cartTextViewPrice.text = "$" + String.format("%.2f", shopItem.price)
        Glide.with(binding.cartImageViewProjectIcon.context)
            .load(shopItem.image)
            .into(binding.cartImageViewProjectIcon)
        binding.buttonRemoveFromCart.setOnClickListener{
            clickListener(shopItem)
        }
        /*if (Beverage.promo) {
            view.cart_text_view_price.setTextColor(Color.parseColor("#F44336"))
        }*/
    }
}