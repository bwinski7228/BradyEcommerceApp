package com.example.ecommerceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.payment_methods.*

class PaymentMethods: AppCompatActivity() {

    private val paymentMethodsList = listOf<PaymentMethod>(
        PaymentMethod("2245", R.drawable.mastercard_logo),
        PaymentMethod("3453", R.drawable.mastercard_logo),
        PaymentMethod("8768", R.drawable.mastercard_logo)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_methods)

        methods_recycler_view.layoutManager = LinearLayoutManager(this)
        // set the custom adapter to the RecyclerView
        methods_recycler_view.adapter = PaymentMethodViewAdapter(paymentMethodsList)
    }
}
