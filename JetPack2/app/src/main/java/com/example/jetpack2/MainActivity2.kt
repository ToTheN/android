package com.example.jetpack2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.jetpack2.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2)

        var i: Intent = intent
        val name =  i.getStringExtra("userName")
        val email = i.getStringExtra("userEmail")
        val phone = i.getStringExtra("userPhone")
        val address = i.getStringExtra("userAddress")

        binding.name1.text = name
        binding.email1.text = email
        binding.phone1.text = phone
        binding.address1.text  = address
    }
}