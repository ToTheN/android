package com.example.navigationcompo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnSubmit: Button = view.findViewById(R.id.button_submit)
        btnSubmit.setOnClickListener {
             validate(view)
        }


    }
    fun validate(view: View): Boolean {
        val navController:NavController = Navigation.findNavController(view)
        val name:EditText = view.findViewById(R.id.edit_name)

        var valid = true
        val s2:String = name.text.toString()
        if ((s2.isEmpty())) {
            Toast.makeText(activity, "please enter your name", Toast.LENGTH_SHORT).show()
            valid = false
        } else {
            val sharedPreferences : SharedPreferences = requireActivity().getSharedPreferences("kotlinsharedpreference",
                Context.MODE_PRIVATE)
            val editor:SharedPreferences.Editor =  sharedPreferences.edit()
            editor.putString("name_key",s2)
            editor.apply()
            editor.commit()
            navController.navigate(R.id.action_loginFragment_to_fragment2)

        }
        return valid
    }

}