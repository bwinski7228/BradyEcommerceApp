package com.example.ecommerceapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.util.Resource
import com.example.ecommerceapp.databinding.FragmentFirstBinding
import com.example.ecommerceapp.databinding.FragmentSecondBinding
import com.example.ecommerceapp.presentation.adapter.CartPageViewAdapter
import com.example.ecommerceapp.presentation.adapter.MyRecyclerViewAdapter
import com.example.ecommerceapp.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.android.synthetic.main.list_item_cart.*


class SecondFragment:Fragment(R.layout.fragment_second) {

    private lateinit var fragmentSecondBinding: FragmentSecondBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var cartAdapter: CartPageViewAdapter
    var  priceTotal : Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        fragmentSecondBinding = FragmentSecondBinding.bind(itemView)
        viewModel = (activity as MainActivity).viewModel
        initRecyclerView()
        fragmentSecondBinding.clearCartButton.setOnClickListener{
            clearButtonClicked()
        }
        viewModel.getCart().observe(viewLifecycleOwner) {
            cartAdapter.differ.submitList(it.toList())
            //val tempCartList = it
            priceTotal = 0.0
            for (item in it) {
                priceTotal += item.price!!
            }
            fragmentSecondBinding.textViewCheckoutTotal.text = "Total: $" + String.format("%.2f", priceTotal)
        }
        fragmentSecondBinding.checkoutButton.setOnClickListener{
            checkoutButtonClicked()
        }
    }

    private fun initRecyclerView() {
        cartAdapter =
            CartPageViewAdapter({ selectedShopItem: ShopItem -> listItemClicked(selectedShopItem) })
        fragmentSecondBinding.cartRecyclerView.apply {
            adapter = cartAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun listItemClicked(shopItem: ShopItem) {
        priceTotal -= shopItem.price!!
        viewModel.deleteShopItem(shopItem)
        Toast.makeText(
            activity,
            "${shopItem.title} has been removed from your cart", Toast.LENGTH_LONG
        ).show()
    }

    private fun clearButtonClicked() {
        viewModel.clearCart()
        priceTotal = 0.0
        fragmentSecondBinding.textViewCheckoutTotal.text = "Total: $" + String.format("%.2f", priceTotal)
        Toast.makeText(
            activity,
            "Cart has been cleared", Toast.LENGTH_LONG
        ).show()
    }

    private fun checkoutButtonClicked() {
        viewModel.clearCart()
        Toast.makeText(
            activity,
            "Your order has been placed for $" + String.format("%.2f", priceTotal), Toast.LENGTH_LONG
        ).show()
        priceTotal = 0.0
    }
}