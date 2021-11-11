package com.example.coroutinelaunchasync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            launcher()
            asyncer()
        }

    }
    // Kotlin Program For better understanding of launch
    fun launcher()
    {
        var resultOne = "Android"
        var resultTwo = "Kotlin"
        Log.i("Launch", "Before")
        CoroutineScope(Dispatchers.IO).launch { resultOne = launch1() }
        CoroutineScope(Dispatchers.IO).launch { resultTwo = launch2() }
        Log.i("Launch", "After")
        val resultText = resultOne + resultTwo
        Log.i("Launch", resultText)
    }

    suspend fun launch1(): String
    {
        delay(1000L)
        val message = "function1"
        Log.i("Launch", message)
        return message
    }

    suspend fun launch2(): String
    {
        delay(100L)
        val message = "function2"
        Log.i("Launch", message)
        return message
    }

    // kotlin program for demonstration of async
    suspend fun asyncer()
    {
        Log.i("Async", "Before")
        val resultOne = CoroutineScope(Dispatchers.IO).async  { async1() }
        val resultTwo = CoroutineScope(Dispatchers.IO).async { async2() }
        Log.i("Async", "After")
       val resultText = resultOne.await() + resultTwo.await()
       Log.i("Async", resultText)
    }

    private suspend fun async1(): String
    {
        delay(1000L)
        val message = "function1"
        Log.i("Async", message)
        return message
    }

    suspend fun async2(): String
    {
        delay(100L)
        val message = "function2"
        Log.i("Async", message)
        return message
    }


}