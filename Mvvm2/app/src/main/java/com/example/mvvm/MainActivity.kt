package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.example.recyclerview.RecyclerAdapter


class MainActivity : AppCompatActivity(),LifecycleOwner {
    var context: MainActivity? = null
    var viewModel: MainViewModel? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       recyclerView = findViewById(R.id.rv_main)
        recyclerViewAdapter = RecyclerAdapter()
        recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView!!.adapter = recyclerViewAdapter

        val userListUpdateObserver:Observer<ArrayList<ListModel>?> = object : Observer<ArrayList<ListModel>?> {

            override fun onChanged(t: ArrayList<ListModel>?) {
                if (t != null) {
                    recyclerViewAdapter?.setListItems(t)
                }
            }
        }

       viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
       viewModel!!.getUserLiveData().observe(this, userListUpdateObserver)
    }
}

