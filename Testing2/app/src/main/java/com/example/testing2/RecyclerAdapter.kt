package com.example.testing2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val listitems:ArrayList<ListModel>,private val recyclerviewClicklistener: RecyclerviewClicklistener) :RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val userName: TextView = itemView.findViewById(R.id.name)
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