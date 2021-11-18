package com.example.testing2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.SupportActionModeWrapper
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerFragment : Fragment(),RecyclerviewClicklistener {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ListModel>

    lateinit var name:Array<String>
   lateinit var email:Array<String>
    lateinit var phone:Array<String>
    lateinit var address:Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_recycler_fragment, container, false)

        name = arrayOf("Tushar","Shivani","Mohit","Rahsil","Madshad","Tushar","Shivani","Mohit","Rahsil","Madshad")

        email = arrayOf("tushar@gmail.com","shivani@gmail.com","mohit@gmail.com","madshad@gmail.com","jaygc@gmail.com","tushar@gmail.com","shivani@gmail.com","mohit@gmail.com","madshad@gmail.com","jaygc@gmail.com")

        phone = arrayOf("9988556425","7854692314","8254967814","9844523678","7854126698","9988556425","7854692314","8254967814","9844523678","7854126698")

        address  = arrayOf("Pathankot, Punjab",
            "Karol Bagh,Delhi",
            "Sultanpur,Madhya Pradesh",
            "Chandigarh,Punjab",
            "Dharamshala,Himachal","Pathankot, Punjab",
            "Karol Bagh,Delhi",
            "Sultanpur,Madhya Pradesh",
            "Chandigarh,Punjab",
            "Dharamshala,Himachal")

        newRecyclerView = view.findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(activity)


        newArrayList = arrayListOf<ListModel>()
        getUserdata()

        return view
    }

    private fun getUserdata()
    {
        name.forEachIndexed { index, i ->
            val listItem = ListModel(name[index])
            newArrayList.add(listItem)
        }

        newRecyclerView.adapter = RecyclerAdapter(newArrayList,this)
    }

     override fun onClick(position: Int) {
         val bundle = Bundle()
         bundle.putString("name",name[position])
         bundle.putString("phone",phone[position])
         bundle.putString("email",email[position])
         bundle.putString("address",address[position])
         val fragment2 = DataFragment()
         fragment2.arguments = bundle
         fragmentManager?.beginTransaction()?.replace(R.id.fragment_container,fragment2)?.commit()
    }

}