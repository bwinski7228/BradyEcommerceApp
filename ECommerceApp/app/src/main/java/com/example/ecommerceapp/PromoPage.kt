package com.example.ecommerceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.util.Resource
import com.example.ecommerceapp.databinding.FragmentFirstBinding
import com.example.ecommerceapp.databinding.PromoPageBinding
import com.example.ecommerceapp.presentation.adapter.MyRecyclerViewAdapter
import com.example.ecommerceapp.presentation.adapter.PromoRecyclerViewAdapter
import com.example.ecommerceapp.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.promo_page.*

class PromoPage: Fragment(R.layout.promo_page) {

    private lateinit var promoPageBinding: PromoPageBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var promoAdapter: PromoRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.promo_page, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        promoPageBinding = PromoPageBinding.bind(itemView)
        viewModel = (activity as MainActivity).viewModel
        initRecyclerView()
        viewPromoList()
    }

    private fun viewPromoList() {
        viewModel.getPromoItems()
        println("PromoAdapterTesting:" + viewModel.promoItems)
        viewModel.promoItems.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        promoAdapter.differ.submitList(it.toList())
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
        promoAdapter = PromoRecyclerViewAdapter({selectedShopItem: ShopItem -> listItemClicked(selectedShopItem)})
        promoPageBinding.promoRecyclerView.apply {
            adapter = promoAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun hideProgressBar() {
        promoPageBinding.progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        promoPageBinding.progressBar.visibility = View.VISIBLE
    }

    private fun listItemClicked(shopItem: ShopItem) {
        Toast.makeText(
            activity,
            "${shopItem.title} has been added to your cart", Toast.LENGTH_LONG
        ).show()
    }








/*val PromoList = listOf(
        Beverage("Sprite", "Sprite", "Coca-Cola", .99, R.drawable.sprite, true),
        Beverage("Mountain Dew", "Mountain Dew Baja Blast", "Pepsi", 1.49, R.drawable.baja_blast, true),
        Beverage("Mountain Dew", "Mountain Dew Code Red", "Pepsi", 1.99, R.drawable.code_red, true),
    )


    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<PromoViewHolder>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.promo_page, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        promo_recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = PromoRecyclerViewAdapter(PromoList, { selectedBeverageItem: Beverage -> listItemClicked(selectedBeverageItem) })
        }
    }

    private fun listItemClicked(Beverage: Beverage) {
        Toast.makeText(
            activity,
            "${Beverage.name} has been added to your cart", Toast.LENGTH_LONG
        ).show()
    }*/
}