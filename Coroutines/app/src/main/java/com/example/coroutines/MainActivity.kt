package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView:TextView = findViewById(R.id.textView)
        var a = 0
        var b  = 1

        CoroutineScope(Dispatchers.Main).launch {
            for(i in 0..9)
            {
                    var c = a+b
                textView.text = c.toString()
                    a = b
                    b = c
                delay(300)
            }
        }
    }
}


