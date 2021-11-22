package com.example.navigationcompo

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    private lateinit var myViewModel : MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navController:NavController = Navigation.findNavController(view)

        var description:TextView = view.findViewById(R.id.description)
        var title:EditText = view.findViewById(R.id.edit_title)

        val button: Button = view.findViewById(R.id.button)

        myViewModel =  ViewModelProvider(this).get(MyViewModel::class.java)

        myViewModel.description.observe(viewLifecycleOwner, Observer {
            description.text = it
        })

        button.setOnClickListener {

            val action:NavDirections = HomeFragmentDirections.actionFragment2ToDialogFragment(title.text.toString())
            navController.navigate(action)
        }
    }

}