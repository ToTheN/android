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

class FourthFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("FRAGMENT4_LIFECYCLE", "onCreateView")

        return inflater.inflate(R.layout.fragment_fourth, container, false)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        Log.i("FRAGMENT4_LIFECYCLE", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("FRAGMENT4_LIFECYCLE", "onCreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.i("FRAGMENT4_LIFECYCLE", "onActivityCreated")

        val addFirstFragmentButton = requireView().findViewById<Button>(R.id.addFirstFragmentBtn)
        addFirstFragmentButton.setOnClickListener {

            // create a FragmentManager
            val fragmentManager = fragmentManager

            // create a FragmentTransaction to begin the transaction and add the Fragment
            val fragmentTransaction = fragmentManager!!.beginTransaction()

            // add the Fragment to existing container
            fragmentTransaction.add(R.id.frameLayout, FirstFragment(), "FIRST_FRAGMENT")
            fragmentTransaction.commit()

        }

        val addSecondFragmentButton = requireView().findViewById<Button>(R.id.addSecondFragmentBtn)
        addSecondFragmentButton.setOnClickListener {

            // create a FragmentManager
            val fragmentManager = fragmentManager

            // create a FragmentTransaction to begin the transaction and add the Fragment
            val fragmentTransaction = fragmentManager!!.beginTransaction()

            // add the Fragment to existing container
            fragmentTransaction.add(R.id.frameLayout, SecondFragment(), "SECOND_FRAGMENT")
            fragmentTransaction.commit()

        }

        val addThirdFragmentButton = requireView().findViewById<Button>(R.id.addThirdFragmentBtn)
        addThirdFragmentButton.setOnClickListener {

            // create a FragmentManager
            val fragmentManager = fragmentManager

            // create a FragmentTransaction to begin the transaction and add the Fragment
            val fragmentTransaction = fragmentManager!!.beginTransaction()

            // add the Fragment to existing container
            fragmentTransaction.add(R.id.frameLayout, ThirdFragment(), "THIRD_FRAGMENT")
            fragmentTransaction.commit()

        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("FRAGMENT4_LIFECYCLE", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("FRAGMENT4_LIFECYCLE", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("FRAGMENT4_LIFECYCLE", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("FRAGMENT4_LIFECYCLE", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("FRAGMENT4_LIFECYCLE", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("FRAGMENT4_LIFECYCLE", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()

        Log.i("FRAGMENT4_LIFECYCLE", "onDetach")
    }
}