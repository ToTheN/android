package com.example.jetpack3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.toColor
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.example.jetpack3.databinding.ActivityMainBinding
import java.lang.Math.random
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var myViewModel : MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button: Button = findViewById(R.id.button)
        myViewModel =  ViewModelProvider(this).get(MyViewModel::class.java)


        myViewModel.oldColor.observe(this, Observer {
            binding.root.setBackgroundResource(it)
        })


        button.setOnClickListener {
           myViewModel.colorUpdate()
        }
    }
}

