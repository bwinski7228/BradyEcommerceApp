package com.example.ecommerceapp.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ecommerceapp.data.model.Rating
import com.example.ecommerceapp.data.model.ShopItem
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShopItemDAOTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: ShopItemDAO
    private lateinit var database: ShopItemDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShopItemDatabase::class.java
        ).build()
        dao = database.getShopItemDAO()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveItemTest() = runBlockingTest {
        val rating = Rating(1,1.0)
        val shopItem = ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)
        dao.insert(shopItem)

        val newShopItem = dao.getShopItems().first()
        Truth.assertThat(newShopItem).isEqualTo(listOf(shopItem))
    }

    @Test
    fun removeItemTest() = runBlockingTest {
        val rating = Rating(1,1.0)
        val shopItem1 = ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)
        val shopItem2 = ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false)
        val shopItem3 = ShopItem(3, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Watch", false)
        dao.insert(shopItem1)
        dao.insert(shopItem2)
        dao.insert(shopItem3)
        dao.deleteShopItem(shopItem2)
        val newShopItem = dao.getShopItems().first()
        Truth.assertThat(newShopItem).isEqualTo(listOf(shopItem1,shopItem3))
    }

    @Test
    fun clearCartTest() = runBlockingTest {
        val rating = Rating(1,1.0)
        val shopItem1 = ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)
        val shopItem2 = ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false)
        val shopItem3 = ShopItem(3, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Watch", false)
        dao.insert(shopItem1)
        dao.insert(shopItem2)
        dao.insert(shopItem3)
        dao.clearCart()
        val newShopItem = dao.getShopItems().first()
        Truth.assertThat(newShopItem).isEqualTo(listOf<ShopItem>())
    }

    @Test
    fun getItemsTest() = runBlockingTest {
        val rating = Rating(1,1.0)
        val shopItem1 = ShopItem(1, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Ring", false)
        val shopItem2 = ShopItem(2, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Necklace", false)
        val shopItem3 = ShopItem(3, "jewelry", "Hello", 1, "placeholder", 22.2, rating, "Watch", false)
        dao.insert(shopItem1)
        dao.insert(shopItem2)
        dao.insert(shopItem3)
        val newShopItem = dao.getShopItems().first()
        Truth.assertThat(newShopItem).isEqualTo(listOf<ShopItem>(shopItem1, shopItem2, shopItem3))
    }
}