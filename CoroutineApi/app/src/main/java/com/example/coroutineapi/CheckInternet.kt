package com.example.coroutineapi

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager

class CheckInternet:Application() {
    companion object {
        private var instance: CheckInternet? = null

        fun getInstance(): CheckInternet? {
            return instance
        }

        fun hasNetwork(): Boolean {
            return instance!!.isNetworkConnected() ?: false
        }
    }

    override fun onCreate() {
        super.onCreate()
        if(instance == null)
        {
            instance = this
        }
    }

    private fun isNetworkConnected():Boolean
    {
        val network = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val active = network.activeNetworkInfo
        return active!= null && active.isConnectedOrConnecting

    }
}