package com.example.ecommerceapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val BeverageList = listOf(
        Beverage("Coke", "Coke Classic", "Coca-Cola", .99, R.drawable.coke_can),
        Beverage("Coke", "Vanilla Coke", "Coca-Cola", 1.49, R.drawable.cherry_coke),
        Beverage("Coke", "Cherry Coke", "Coca-Cola", 1.99, R.drawable.coca_cola_vanilla),
        Beverage("Sprite", "Sprite", "Coca-Cola", .99, R.drawable.sprite),
        Beverage("Mountain Dew", "Mountain Dew", "Pepsi", .99, R.drawable.mtn_dew),
        Beverage("Mountain Dew", "Mountain Dew Baja Blast", "Pepsi", 1.49, R.drawable.baja_blast),
        Beverage("Mountain Dew", "Mountain Dew Code Red", "Pepsi", 1.99, R.drawable.code_red),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recyclerView.setBackgroundColor(Color.rgb(255, 245, 179))
        my_recyclerView.layoutManager = LinearLayoutManager(this)
        my_recyclerView.adapter = MyRecyclerViewAdapter(BeverageList, {selectedBeverageItem:Beverage->listItemClicked(selectedBeverageItem)})

        val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()
        val thirdFragment=ThirdFragment()

        setCurrentFragment(firstFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.person->setCurrentFragment(secondFragment)
                R.id.settings->setCurrentFragment(thirdFragment)

            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

    private fun listItemClicked(Beverage: Beverage) {
        Toast.makeText(this@MainActivity,
            "Supplier name is ${Beverage.producer}", Toast.LENGTH_LONG).show()
    }
}