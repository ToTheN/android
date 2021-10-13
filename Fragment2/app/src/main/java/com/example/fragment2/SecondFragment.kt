package com.example.fragment2

import android.app.Activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragment2.R

class SecondFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("FRAGMENT2_LIFECYCLE", "onCreateView")

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        Log.i("FRAGMENT2_LIFECYCLE", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("FRAGMENT2_LIFECYCLE", "onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.i("FRAGMENT2_LIFECYCLE", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()

        Log.i("FRAGMENT2_LIFECYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("FRAGMENT2_LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("FRAGMENT2_LIFECYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("FRAGMENT2_LIFECYCLE", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("FRAGMENT2_LIFECYCLE", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("FRAGMENT2_LIFECYCLE", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()

        Log.i("FRAGMENT2_LIFECYCLE", "onDetach")
    }
}