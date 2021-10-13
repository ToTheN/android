package com.example.fragment2

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment2.R

class ThirdFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("FRAGMENT3_LIFECYCLE", "onCreateView")

        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        Log.i("FRAGMENT3_LIFECYCLE", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("FRAGMENT3_LIFECYCLE", "onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.i("FRAGMENT3_LIFECYCLE", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()

        Log.i("FRAGMENT3_LIFECYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("FRAGMENT3_LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("FRAGMENT3_LIFECYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("FRAGMENT3_LIFECYCLE", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("FRAGMENT3_LIFECYCLE", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("FRAGMENT3_LIFECYCLE", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()

        Log.i("FRAGMENT3_LIFECYCLE", "onDetach")
    }
}