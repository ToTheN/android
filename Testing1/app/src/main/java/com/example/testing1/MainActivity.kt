package com.example.testing1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ListView
import com.example.testing1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button1.setOnClickListener {

            binding.checkbox.toggle()
            binding.button1.isEnabled = false
            binding.button2.isEnabled = true
        }

        binding.button2.setOnClickListener {
            binding.checkbox.toggle()
            binding.button2.isEnabled = false
            binding.button1.isEnabled = true
        }



    }
}