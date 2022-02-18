package com.example.ecommerceapp.data.db

import androidx.room.*
import com.example.ecommerceapp.data.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM users")
    fun getUsers(): MutableList<User>
}