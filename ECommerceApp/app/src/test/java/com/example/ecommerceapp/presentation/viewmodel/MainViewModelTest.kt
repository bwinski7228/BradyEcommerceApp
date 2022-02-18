package com.example.ecommerceapp.presentation.viewmodel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ecommerceapp.data.model.Rating
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.model.User
import com.example.ecommerceapp.data.repository.shopItem.FakeShopRepository
import com.example.ecommerceapp.domain.usecase.*
import com.example.ecommerceapp.getOrAwaitValue
import com.example.ecommerceapp.presentation.ShopApp
import com.google.common.truth.Truth.assertThat
import junit.framework.TestCase
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Mock
    lateinit var application: ShopApp

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
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
        val cart = mutableListOf((ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)), ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false))

        val currCart = viewModel.getCart().getOrAwaitValue()
        assertThat(currCart).isEqualTo(cart)
    }

    @Test
    fun addItemToCartTest() {
        val rating = Rating(1,1.0)
        val cart = mutableListOf((ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)), ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false))
        val newItem = ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Watch", false)
        cart.add(newItem)
        viewModel.addItemToList(newItem)
        val currCart = viewModel.getCart().getOrAwaitValue()
        assertThat(currCart).isEqualTo(cart)
    }

    @Test
    fun removeItemFromCartTest() {
        val rating = Rating(1,1.0)
        val cart = mutableListOf((ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)), ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false))
        cart.remove(ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false))
        viewModel.deleteShopItem(ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false))
        val currCart = viewModel.getCart().getOrAwaitValue()
        assertThat(currCart).isEqualTo(cart)
    }

    @Test
    fun clearCartTest() {
        val rating = Rating(1,1.0)
        val cart = mutableListOf<ShopItem>()
        viewModel.clearCart()
        val currCart = viewModel.getCart().getOrAwaitValue()
        assertThat(currCart).isEqualTo(cart)
    }

    @Test
    fun addUserTest() {
        val users = mutableListOf(User(1, "Brady", "bwinski@gmail.com", 1), User(1, "Jack", "bwinski@gmail.com", 1), User(1, "Liam", "bwinski@gmail.com", 1))
        val newUser = User(1, "Jake", "bwinski@gmail.com", 1)
        users.add(newUser)
        viewModel.addUserToList(newUser)
        val currUsers = viewModel.getUsers()
        assertThat(currUsers).isEqualTo(users)
    }

    @Test
    fun getUsersTest() {
        val users = mutableListOf(User(1, "Brady", "bwinski@gmail.com", 1), User(1, "Jack", "bwinski@gmail.com", 1), User(1, "Liam", "bwinski@gmail.com", 1))
        val currUsers = viewModel.getUsers()
        assertThat(currUsers).isEqualTo(users)
    }
}