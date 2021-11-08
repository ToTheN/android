package com.example.jetpack2.Recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack2.MainActivity2
import com.example.jetpack2.R
import com.example.jetpack2.Recyclerview.CustomAdapter.MyViewHolder

class CustomAdapter(private val listitems:ArrayList<ListModel>,private val recyclerviewClicklistener: RecyclerviewClicklistener) :RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val userName:TextView = itemView.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
         val curentItem = listitems[position]
         holder.userName.text = curentItem.name
        holder.itemView.setOnClickListener {
            recyclerviewClicklistener.onClick(position)
        }

    }

    override fun getItemCount(): Int {
      return listitems.size
    }

}