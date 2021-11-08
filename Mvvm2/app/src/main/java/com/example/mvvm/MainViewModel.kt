package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList

class MainViewModel : ViewModel() {
    private var userLiveData: MutableLiveData<ArrayList<ListModel>> = MutableLiveData<ArrayList<ListModel>>()

     init{
        userLiveData.value = populateList()
    }

    fun getUserLiveData(): LiveData<ArrayList<ListModel>?>
    {
        return userLiveData
    }

    fun populateList():ArrayList<ListModel> {
        val listModel = ListModel("Darknight","Best rating movie","null")
        val userArrayList = ArrayList<ListModel>()
        userArrayList.add(listModel)
        userArrayList.add(listModel)
        userArrayList.add(listModel)
        userArrayList.add(listModel)
        userArrayList.add(listModel)
        userArrayList.add(listModel)
        return userArrayList
    }

}