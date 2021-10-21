package com.example.webservices

import Json4Kotlin_Base
import Posts
import org.w3c.dom.Entity
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

const val BASE_URL="https://storage.googleapis.com/network-security-conf-codelab.appspot.com/"

interface ApiInterface {
    @GET("v2/posts.json")
    fun getpost(): Call<Json4Kotlin_Base>

}
object Apiservice
{
    val newInstance:ApiInterface
    init {
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newInstance = retrofit.create(ApiInterface::class.java)
    }
}