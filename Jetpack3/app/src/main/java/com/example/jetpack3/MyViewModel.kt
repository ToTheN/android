package com.example.jetpack3

import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class MyViewModel: ViewModel() {
    val oldColor = MutableLiveData(R.color.design_default_color_background)

    fun colorUpdate()
    {
       var color = arrayOf(R.color.green,R.color.orange,R.color.purple)
        oldColor.value = color.random()
    }

    override fun onCleared() {
        super.onCleared()
    }
}

