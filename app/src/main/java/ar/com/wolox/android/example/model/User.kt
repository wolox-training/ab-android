package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("email")
    private lateinit var email: String
    @SerializedName("password")
    private lateinit var password: String

    fun getEmail(): String {
        return email
    }

    fun getPassword(): String {
        return password
    }
}