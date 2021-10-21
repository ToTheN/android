package com.example.webservices2

import Json4Kotlin_Base
import Posts
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webservices.Apiservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    var data = ArrayList<Posts>()
    private lateinit var adapterclass: Adapterclass
    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapterclass = Adapterclass(data,baseContext)
        recyclerView.adapter = adapterclass



        getpost()
    }


    private fun getpost() {
        val api = Apiservice.newInstance.getpost()

            api.enqueue(object : Callback<Json4Kotlin_Base?> {
                override fun onResponse(
                    call: Call<Json4Kotlin_Base?>,
                    response: Response<Json4Kotlin_Base?>
                ) {
                    val aa = response.body()!!
                    val ab = aa?.posts

                        data.addAll(ab)
                        adapterclass.notifyDataSetChanged()

                }

                override fun onFailure(call: Call<Json4Kotlin_Base?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })



    }

}
