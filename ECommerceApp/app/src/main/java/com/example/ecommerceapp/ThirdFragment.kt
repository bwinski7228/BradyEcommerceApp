package com.example.ecommerceapp

import android.content.Intent
import android.os.Bundle
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.ecommerceapp.data.model.User
import com.example.ecommerceapp.databinding.FragmentFirstBinding
import com.example.ecommerceapp.databinding.FragmentThirdBinding
import com.example.ecommerceapp.presentation.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_third.*
import kotlinx.coroutines.launch

class ThirdFragment:Fragment(R.layout.fragment_third) {

    private lateinit var fragmentThirdBinding: FragmentThirdBinding
    private lateinit var viewModel: MainViewModel

    var user: User = User(1, "blehhhh", "blehhblehh@nttdata.com", R.drawable.comp_pic)
    val dummyUser: UserData = UserData("Brady Winski", "Brady.Winski@nttdata.com", R.drawable.comp_pic)
    private var currUser = User(1, "Brady Winski", "Brady.Winski@nttdata.com", R.drawable.comp_pic)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        fragmentThirdBinding = FragmentThirdBinding.bind(itemView)
        viewModel = (activity as MainActivity).viewModel
        fragmentThirdBinding.viewModel = viewModel
        fragmentThirdBinding.lifecycleOwner = this
        if(viewModel.getUsers().isEmpty()) {
            viewModel.addUserToList(currUser)
        }
        user = viewModel.getUsers()[0]
        fragmentThirdBinding.textViewProfileName.text = user.name
        fragmentThirdBinding.textViewProfileAddress.text = user.email
        fragmentThirdBinding.imageViewProfileIcon.setImageResource(dummyUser.proPic)
        fragmentThirdBinding.textViewProfileMethods.setOnClickListener {
            onMethodsClicked()
        }
        fragmentThirdBinding.textViewProfileOrders.setOnClickListener {
            onOrdersClicked()
        }
    }

    private fun onMethodsClicked() {

        //val testString = "Contact Name: $contactName, Contact Number: $contactNumber, My Display Name: $myDisplayName, Include Junior: $includeJunior, Job Title: $jobTitle, Immediate Start: $immediateStart, Start Date: $startDate"

        //Toast.makeText(this, testString, Toast.LENGTH_LONG).show()

        val paymentMethodsIntent = Intent(activity, PaymentMethods::class.java)
        activity?.startActivity(paymentMethodsIntent)
    }

    private fun onOrdersClicked() {

        val prevOrdersIntent = Intent(activity, PrevOrderPage::class.java)
        activity?.startActivity(prevOrdersIntent)
    }
}

