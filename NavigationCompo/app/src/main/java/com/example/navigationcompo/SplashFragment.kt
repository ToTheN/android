package com.example.navigationcompo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.HandlerCompat.postDelayed
import androidx.navigation.NavController
import androidx.navigation.Navigation

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view:View =  inflater.inflate(R.layout.fragment_splash, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navController:NavController= Navigation.findNavController(view)
        Handler(Looper.getMainLooper()).postDelayed(object:Runnable {
            override fun run() {
              /*  val loginFragment = LoginFragment()
                loginFragment.validate(view)
                val sharedPreferences : SharedPreferences = requireActivity().getSharedPreferences("kotlinsharedpreference",
                    Context.MODE_PRIVATE)
                if(sharedPreferences.contains(null))
                {
                    navController.navigate(R.id.action_fragment1_to_loginFragment)
                }
                else{
                    navController.navigate(R.id.action_fragment1_to_fragment2)
                }

               */
                navController.navigate(R.id.action_fragment1_to_loginFragment)


            } },3000)
    }
}