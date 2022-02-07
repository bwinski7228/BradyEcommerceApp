package com.example.ecommerceapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.bottomNavigationView
import kotlinx.android.synthetic.main.fragment_first.*

class MainActivity : AppCompatActivity() {

    val BeverageList = listOf(
        Beverage("Coke", "Coke Classic", "Coca-Cola", .99, R.drawable.coke_can),
        Beverage("Coke", "Vanilla Coke", "Coca-Cola", 1.49, R.drawable.coca_cola_vanilla ),
        Beverage("Coke", "Cherry Coke", "Coca-Cola", 1.99, R.drawable.cherry_coke),
        Beverage("Sprite", "Sprite", "Coca-Cola", .99, R.drawable.sprite, true),
        Beverage("Mountain Dew", "Mountain Dew", "Pepsi", .99, R.drawable.mtn_dew),
        Beverage("Mountain Dew", "Mountain Dew Baja Blast", "Pepsi", 1.49, R.drawable.baja_blast, true),
        Beverage("Mountain Dew", "Mountain Dew Code Red", "Pepsi", 1.99, R.drawable.code_red, true),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Main Bev List: " + getBevList())

        for (bev in BeverageList) {
            if (bev.promo) {
                bev.price = (bev.price - .5)
            }
        }

//        my_recycler_view.layoutManager = LinearLayoutManager(this)
//        my_recycler_view.adapter = MyRecyclerViewAdapter(
//            BeverageList,
//            { selectedBeverageItem: Beverage -> listItemClicked(selectedBeverageItem) })

        val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()
        val thirdFragment=ThirdFragment()
        val fourthFragment=PromoPage()

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.shop->setCurrentFragment(firstFragment)
                R.id.cart->setCurrentFragment(secondFragment)
                R.id.profile->setCurrentFragment(thirdFragment)
                R.id.promos->setCurrentFragment(fourthFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

    fun getBevList(): List<Beverage> {
        return BeverageList
    }

    fun getBevList2(): List<Beverage> {
        return listOf(
            Beverage("Coke", "Coke Classic", "Coca-Cola", .99, R.drawable.coke_can),
            Beverage("Coke", "Vanilla Coke", "Coca-Cola", 1.49, R.drawable.coca_cola_vanilla ),
            Beverage("Coke", "Cherry Coke", "Coca-Cola", 1.99, R.drawable.cherry_coke),
            Beverage("Sprite", "Sprite", "Coca-Cola", .99, R.drawable.sprite, true),
            Beverage("Mountain Dew", "Mountain Dew", "Pepsi", .99, R.drawable.mtn_dew),
            Beverage("Mountain Dew", "Mountain Dew Baja Blast", "Pepsi", 1.49, R.drawable.baja_blast, true),
            Beverage("Mountain Dew", "Mountain Dew Code Red", "Pepsi", 1.99, R.drawable.code_red, true),
        )
    }
}