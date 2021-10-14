package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<listModel>

    lateinit var image:Array<Int>
    lateinit var des:Array<String>
    lateinit var date:Array<String>
    lateinit var rate:Array<Int>
    lateinit var amout:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        image = arrayOf(R.drawable.icecream,
            R.drawable.icecream,
            R.drawable.icecream,
            R.drawable.icecream,
            R.drawable.icecream,
            R.drawable.icecream,
            R.drawable.icecream)

        des = arrayOf( "CupCake IceCream \n145 Mall of India \n 520 views",
            "CupCake IceCream \n145 Mall of India \n 520 views",
            "CupCake IceCream  \n145 Mall of India \n 520 views",
            "CupCake IceCream  \n145 Mall of India \n 520 views",
            "CupCake IceCream  \n145 Mall of India \n 520 views",
            "CupCake IceCream  \n145 Mall of India \n 520 views",
            "CupCake IceCream  \n145 Mall of India \n 520 views")


        date = arrayOf("5 Oct 2021  11:30 AM",
        "5 Oct 2021  11:30 AM",
        "5 Oct 2021  11:30 AM",
        "5 Oct 2021  11:30 AM",
        "5 Oct 2021  11:30 AM",
        "5 Oct 2021  11:30 AM",
        "5 Oct 2021  11:30 AM")

        rate = arrayOf(R.id.rating,
            R.id.rating,
                    R.id.rating,
                    R.id.rating,
                    R.id.rating,
                    R.id.rating,
                    R.id.rating)

        amout = arrayOf("Rs. 180",
            "Rs. 280",
            "Rs. 380",
            "Rs. 480",
            "Rs. 280",
            "Rs. 680",
            "Rs. 180")


        newRecyclerView = findViewById(R.id.recycle)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)


        newArrayList = arrayListOf<listModel>()
        getuserdata()



        }

    private fun getuserdata()
    {
        for(i in image.indices){
            val listItem = listModel(des[i],date[i],image[i],amout[i].toString(),rate[i])
            newArrayList.add(listItem)
        }

        newRecyclerView.adapter = CustomAdapter(newArrayList)
    }



}

