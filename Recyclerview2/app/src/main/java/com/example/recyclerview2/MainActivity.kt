package com.example.recyclerview2

import android.nfc.tech.MifareUltralight
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.ListModel
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL
import android.widget.ProgressBar


class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newmutableList: MutableList<ListModel>
    private var isScrolling:Boolean = false
    private lateinit var customAdapter: CustomAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        newmutableList = mutableListOf<ListModel>()

//        newmutableList.add(ListModel(CustomAdapter.VIEW_TEXT_MESSAGE,0,0,"New Offer avail discount",""))

//        newmutableList.add(ListModel(CustomAdapter.VIEW_FAVORITE_ITEM,0,R.drawable.icecream,"Ice Cream Sundae",""))
//        newmutableList.add(ListModel(CustomAdapter.VIEW_OFFER_IMAGE,0,R.drawable.offer,"", ""))
        for (i in 1..9) {
            when {
                i % 2 == 0 -> {
                    newmutableList.add(ListModel(CustomAdapter.VIEW_TEXT_MESSAGE,0,0,"New Offer avail discount",""))
                }
                i % 3 == 0 -> {
                    newmutableList.add(ListModel(CustomAdapter.VIEW_FAVORITE_ITEM,0,R.drawable.icecream,"Ice Cream Sundae",""))
                }
                else -> {
                    newmutableList.add(ListModel(CustomAdapter.VIEW_OFFER_IMAGE,0,R.drawable.offer,"", ""))
                }
            }
        }


        newRecyclerView = findViewById(R.id.recycle)
        customAdapter = CustomAdapter(newmutableList,this)
        layoutManager = LinearLayoutManager(this)
        newRecyclerView.layoutManager = layoutManager


        newRecyclerView.adapter = customAdapter

        newRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                super.onScrollStateChanged(recyclerView, newState)

                if(newState ==AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                     isScrolling = true
                }
            }


            //After reaching the last element it fetches the data
             override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val currentItems:Int = layoutManager.childCount
                val totalItems:Int = layoutManager.itemCount
                val scrollOutItems:Int = layoutManager.findFirstVisibleItemPosition()
                if (isScrolling && (currentItems + scrollOutItems == totalItems))
                {
                    isScrolling = false
                    Log.i("last", "Lastpage")
                    fetchData()
                }

            }
        })

    }

    private fun fetchData() {
        val progressBar = findViewById<ProgressBar>(R.id.progressbar)
progressBar.visibility = View.VISIBLE
        //Delays for 2 sec and then fetches data
        val handler = Handler()
        handler.postDelayed({
            for (i in 1..9) {
                when {
                    i % 2 == 0 -> {
                        newmutableList.add(ListModel(CustomAdapter.VIEW_TEXT_MESSAGE,0,0,"New Offer avail discount",""))
                    }
                    i % 3 == 0 -> {
                        newmutableList.add(ListModel(CustomAdapter.VIEW_FAVORITE_ITEM,0,R.drawable.icecream,"Ice Cream Sundae",""))
                    }
                    else -> {
                        newmutableList.add(ListModel(CustomAdapter.VIEW_OFFER_IMAGE,0,R.drawable.offer,"", ""))
                    }
                }
                progressBar.visibility = View.GONE
            }
            customAdapter.notifyDataSetChanged()
        }, 2000)

    }

}








