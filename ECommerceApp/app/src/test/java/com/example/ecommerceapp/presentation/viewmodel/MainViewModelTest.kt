package com.example.ecommerceapp.presentation.viewmodel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ecommerceapp.data.model.Rating
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.repository.shopItem.FakeShopRepository
import com.example.ecommerceapp.domain.usecase.*
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        val application = Application()
        val fakeShopRepository = FakeShopRepository()
        val getItemsUseCase = GetItemsUseCase(fakeShopRepository)
        val getPromoItemsUseCase = GetPromoItemsUseCase(fakeShopRepository)
        val addItemToCartUseCase = AddItemToCartUseCase(fakeShopRepository)
        val deleteItemInCartUseCase = DeleteItemInCartUseCase(fakeShopRepository)
        val clearCartUseCase = ClearCartUseCase(fakeShopRepository)
        val getCartUseCase = GetCartUseCase(fakeShopRepository)
        val getUsersUseCase = GetUsersUseCase(fakeShopRepository)
        val addUserUseCase = AddUserUseCase(fakeShopRepository)
        viewModel = MainViewModel(application, getItemsUseCase, getPromoItemsUseCase, addItemToCartUseCase, getCartUseCase, deleteItemInCartUseCase, clearCartUseCase, addUserUseCase, getUsersUseCase)
    }

    @Test
    fun getCartTest() {
        val rating = Rating(1,1.0)
        val cart = flowOf(mutableListOf((ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)), ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false)))

        val currCart = viewModel.getCart()
        assertThat(currCart).isEqualTo(cart)
    }

    @Test
    fun addItemToCartTest() {
        val rating = Rating(1,1.0)
        val cart = flowOf(mutableListOf((ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)), ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false)))

        val currCart = viewModel.getCart()
        assertThat(currCart).isEqualTo(cart)
    }

    @Test
    fun removeItemFromCartTest() {
        val rating = Rating(1,1.0)
        val cart = flowOf(mutableListOf((ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)), ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false)))

        val currCart = viewModel.getCart()
        assertThat(currCart).isEqualTo(cart)
    }

    @Test
    fun clearCartTest() {
        val rating = Rating(1,1.0)
        val cart = flowOf(mutableListOf((ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)), ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false)))

        val currCart = viewModel.getCart()
        assertThat(currCart).isEqualTo(cart)
    }
}