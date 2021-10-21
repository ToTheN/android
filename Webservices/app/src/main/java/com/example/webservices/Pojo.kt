package com.example.webservices

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pojo(
    @SerializedName("userId")
    @Expose
    val userId: Int,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("body")
    @Expose
    val body:String
    )
