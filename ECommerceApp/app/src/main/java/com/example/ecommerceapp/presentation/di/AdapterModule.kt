package com.example.ecommerceapp.presentation.di

import android.widget.Toast
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.presentation.adapter.MyRecyclerViewAdapter
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    /*@Singleton
    fun provideShopAdapter():MyRecyclerViewAdapter {
        return MyRecyclerViewAdapter()
    }

    private var onItemClickListener : ((ShopItem)->Unit)? = null

    fun setOnItemClickListener(listener : (ShopItem)->Unit) {
        onItemClickListener = listener
    }
    private fun listItemClicked(shopItem: ShopItem) {
        Toast.makeText(
            getActivity(),
            "${shopItem.title} has been added to your cart", Toast.LENGTH_LONG
        ).show()
    }*/
}