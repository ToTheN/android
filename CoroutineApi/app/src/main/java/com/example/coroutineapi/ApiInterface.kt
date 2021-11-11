package com.example.coroutineapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

const val BASE_URL= "https://jsonplaceholder.typicode.com/posts/"

interface ApiInterface {
    @GET("/posts")
    fun getPost(): Call<List<User>>?

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