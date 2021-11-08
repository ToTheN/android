package com.example.jetpack2

import android.annotation.SuppressLint
import android.app.FragmentManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack2.Recyclerview.CustomAdapter
import com.example.jetpack2.Recyclerview.ListModel
import com.example.jetpack2.Recyclerview.RecyclerviewClicklistener

class MainActivity : AppCompatActivity(),RecyclerviewClicklistener {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ListModel>


    lateinit var name:Array<String>
    lateinit var email:Array<String>
    lateinit var phone:Array<String>
    lateinit var address:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = arrayOf("Tushar","Shivani","Mohit","Rahsil","Madshad","Tushar","Shivani","Mohit","Rahsil","Madshad")

        email = arrayOf("tushar@gmail.com","shivani@gmail.com","mohit@gmail.com","madshad@gmail.com","jaygc@gmail.com","tushar@gmail.com","shivani@gmail.com","mohit@gmail.com","madshad@gmail.com","jaygc@gmail.com")

        phone = arrayOf("9988556425","7854692314","8254967814","9844523678","7854126698","9988556425","7854692314","8254967814","9844523678","7854126698")

        address  = arrayOf("Pathankot, Punjab",
            "Karol Bagh,Delhi",
            "Sultanpur,Madhya Pradesh",
            "Chandigarh,Punjab",
            "Dharamshala,Himachal","Pathankot, Punjab",
            "Karol Bagh,Delhi",
            "Sultanpur,Madhya Pradesh",
            "Chandigarh,Punjab",
            "Dharamshala,Himachal")

        newRecyclerView = findViewById(R.id.recycler)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)


        newArrayList = arrayListOf<ListModel>()
        getUserdata()

    }

    private fun getUserdata()
    {
        name.forEachIndexed { index, i ->
            val listItem = ListModel(name[index])
            newArrayList.add(listItem)
        }

        newRecyclerView.adapter = CustomAdapter(newArrayList,this)
    }

    override fun onClick(position: Int) {
        val intent = Intent(this, MainActivity2::class.java).also {
            it.putExtra("userName",name[position])
            it.putExtra("userEmail",email[position])
            it.putExtra("userPhone",phone[position])
            it.putExtra("userAddress",address[position])
            startActivity(it)
        }

    }
}

