package ar.com.wolox.android.example.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class News(@SerializedName("createdAt") val createdAt: String, val title: String, val text: String, val picture: String, var like: Boolean = false) : Serializable