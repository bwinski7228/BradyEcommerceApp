package com.example.ecommerceapp.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.ecommerceapp.data.model.Rating
import com.example.ecommerceapp.data.model.ShopItem
import com.example.ecommerceapp.data.model.User
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserDAOTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: UserDAO
    private lateinit var database: UserDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            UserDatabase::class.java
        ).build()
        dao = database.getUserDAO()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveUserTest() = runBlockingTest {
        val user = User(1, "Brady", "bwinski@gmail.com", 1)
        dao.insert(user)
        val newUser = dao.getUsers()
        Truth.assertThat(newUser).isEqualTo(listOf(user))
    }

    @Test
    fun getUserTest() = runBlockingTest {
        val user1 = User(1, "Brady", "bwinski@gmail.com", 1)
        val user2 = User(2, "John", "bwinski@gmail.com", 1)
        val user3 = User(3, "Bob", "bwinski@gmail.com", 1)
        dao.insert(user1)
        dao.insert(user2)
        dao.insert(user3)
        val newShopItem = dao.getUsers()
        Truth.assertThat(newShopItem).isEqualTo(listOf(user1, user2, user3))
    }
}