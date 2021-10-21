package com.example.webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException
import java.net.UnknownHostException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getpost()
    }

    private fun getpost()
    {
        val api = Apiservice.newInstance.getpost(1)
        if (api != null) {
            api.enqueue(object :Callback<List<Pojo>> {
                override fun onResponse(call: Call<List<Pojo>>, response: Response<List<Pojo>>) {
                    val pojo: List<Pojo>? = response.body()
                    if (pojo != null) {
                        val list: ListView = findViewById(R.id.list)
                        val adp: ArrayAdapter<Pojo> = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1,pojo)
                        list.adapter = adp

                    }
                }

                override fun onFailure(call: Call<List<Pojo>>, t: Throwable) {
                       Log.d("fail","unable to fetch")
                }


            })
        }

    }

}