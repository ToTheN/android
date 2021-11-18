package com.example.navigationcompo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    var description = MutableLiveData(" ")

    fun Update(change:String)
    {
       description.value = change
    }

    override fun onCleared() {
        super.onCleared()
    }
}

