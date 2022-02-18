package com.example.ecommerceapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "users"
)
data class User(
    @PrimaryKey(autoGenerate = true)
    val key : Int? = null,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("image")
    val image: Int?,
): Serializable