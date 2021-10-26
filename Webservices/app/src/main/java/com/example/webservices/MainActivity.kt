package com.example.webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPost()
    }

    private fun getPost()
    {
        val api = Apiservice.newInstance.getPost(1)
        if (api != null) {
            api.enqueue(object :Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    val user: List<User>? = response.body()
                    if (user != null) {
                        val list: ListView = findViewById(R.id.list)
                        val adp: ArrayAdapter<User> = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1,user)
                        list.adapter = adp

                    }
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                       Log.d("fail","unable to fetch")
                }


            })
        }

    }

}