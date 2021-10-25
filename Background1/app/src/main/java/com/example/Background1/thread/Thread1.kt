package com.example.Background1.thread

import android.util.Log
import java.lang.Exception

class Thread1: Thread() {

    val TAG = "thread1"

    override fun run() {
        for(i in 1..4) {
            try {
                Thread.sleep(500)
            } catch (e: Exception) {
                Log.i(TAG,"e")
            }
            Log.i(TAG, "value$i")
        }
        }


}