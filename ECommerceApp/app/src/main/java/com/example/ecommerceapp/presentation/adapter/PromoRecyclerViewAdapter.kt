package com.example.ecommerceapp.presentation.adapter

import android.graphics.Color
import android.graphics.drawable.Drawable
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
import kotlinx.android.synthetic.main.list_item.view.*
import java.io.InputStream
import java.net.URL


class PromoRecyclerViewAdapter(private val clickListener:(ShopItem)->Unit): RecyclerView.Adapter<PromoRecyclerViewAdapter.PromoViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<ShopItem>() {
        override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    var promoList: MutableList<ShopItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val binding = ListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        /*getPromos()
        println("Promolistlesgo: " + promoList)*/
        return PromoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        //var promoList = getPromos()
        println("promolistinadapter: " + differ.currentList)
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PromoRecyclerViewAdapter.PromoViewHolder, position: Int) {
        //var promoList = getPromos()
        val shopItem = differ.currentList[position]
        holder.bind(shopItem, clickListener)
    }

    inner class PromoViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(shopItem: ShopItem, clickListener:(ShopItem)->Unit) {
            binding.nameTextView.text = shopItem.title
            binding.textViewPrice.text = "$" + shopItem.price.toString()
            //binding.imageViewProjectIcon.setImageResource(ShopItem.image)

            Glide.with(binding.imageViewProjectIcon.context)
                .load(shopItem.image)
                .into(binding.imageViewProjectIcon)
            //binding.imageViewProjectIcon.src = LoadImageFromWebOperations(shopItem.image)

            binding.buttonAddToCart.setOnClickListener{
                clickListener(shopItem)
            }
            /*if (ShopItem.promo) {
                binding.textViewPrice.setTextColor(Color.parseColor("#F44336"))
            }*/
        }

        fun LoadImageFromWebOperations(url: kotlin.String?): Drawable? {
            return try {
                val `is`: InputStream = URL(url).getContent() as InputStream
                Drawable.createFromStream(`is`, "src name")
            } catch (e: java.lang.Exception) {
                null
            }
        }
    }

}





/*
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
}*/
