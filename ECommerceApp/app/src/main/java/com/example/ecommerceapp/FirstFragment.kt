package com.example.ecommerceapp

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.util.Resource
import com.example.ecommerceapp.databinding.FragmentFirstBinding
import com.example.ecommerceapp.presentation.adapter.MyRecyclerViewAdapter
import com.example.ecommerceapp.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import java.io.InputStream
import java.io.Serializable
import java.net.URL
import javax.inject.Inject


class FirstFragment:Fragment(R.layout.fragment_first) {

    private lateinit var fragmentFirstBinding: FragmentFirstBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var shopAdapter: MyRecyclerViewAdapter
    private var isLoading = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        fragmentFirstBinding = FragmentFirstBinding.bind(itemView)
        viewModel = (activity as MainActivity).viewModel
        initRecyclerView()
        viewShopList()
    }

    private fun viewShopList() {
        viewModel.getShopItems()
        viewModel.shopItems.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        shopAdapter.differ.submitList(it.toList())
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity, "An error occurred : $it", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        }
    }

    private fun initRecyclerView() {
        shopAdapter =
            MyRecyclerViewAdapter({ selectedShopItem: ShopItem -> listItemClicked(selectedShopItem) })
        fragmentFirstBinding.myRecyclerView.apply {
            adapter = shopAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun hideProgressBar() {
        isLoading = false
        fragmentFirstBinding.progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        isLoading = true
        fragmentFirstBinding.progressBar.visibility = View.VISIBLE
    }

    private fun listItemClicked(shopItem: ShopItem) {
        viewModel.addItemToList(shopItem)
        Toast.makeText(
            activity,
            "${shopItem.title} has been added to your cart", Toast.LENGTH_LONG
        ).show()
    }
}

