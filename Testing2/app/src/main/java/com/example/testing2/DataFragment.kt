package com.example.testing2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DataFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_data, container, false)

        val name1:TextView = view.findViewById(R.id.name1)
        val email1:TextView = view.findViewById(R.id.email1)
        val phone1:TextView = view.findViewById(R.id.phone1)
        val address1:TextView = view.findViewById(R.id.address1)


        val bundle: Bundle? = this.arguments
        if (bundle != null)
        {
            name1.text = bundle.getString("name")
            email1.text = bundle.getString("email")
            phone1.text = bundle.getString("phone")
            address1.text = bundle.getString("address")
        }


        return view
    }
}