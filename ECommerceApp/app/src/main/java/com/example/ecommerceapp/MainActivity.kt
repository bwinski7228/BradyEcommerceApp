package com.example.ecommerceapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val BeverageList = listOf(
        Beverage("Coke", "Classic", "Coca-Cola"),
        Beverage("Coke", "Vanilla", "Coca-Cola"),
        Beverage("Coke", "Cherry", "Coca-Cola"),
        Beverage("Sprite", "Classic", "Coca-Cola"),
        Beverage("Mountain Dew", "Classic", "Pepsi"),
        Beverage("Mountain Dew", "Baja Blast", "Pepsi"),
        Beverage("Mountain Dew", "Code Red", "Pepsi"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recyclerView.setBackgroundColor(Color.YELLOW)
        my_recyclerView.layoutManager = LinearLayoutManager(this)
        my_recyclerView.adapter = MyRecyclerViewAdapter(BeverageList, {selectedBeverageItem:Beverage->listItemClicked(selectedBeverageItem)})
    }

    private fun listItemClicked(Beverage: Beverage) {
        Toast.makeText(this@MainActivity,
            "Supplier name is ${Beverage.producer}", Toast.LENGTH_LONG).show()
    }
}