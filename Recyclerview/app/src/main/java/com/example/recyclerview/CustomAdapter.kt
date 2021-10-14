package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val listitems:ArrayList<listModel>):RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){

   inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

       // val image1:ImageView = itemView.findViewById(R.id.image1)
        val des:TextView = itemView.findViewById(R.id.des)
        val date:TextView = itemView.findViewById(R.id.date)
        val amount:TextView = itemView.findViewById(R.id.amount)
        val rate:RatingBar = itemView.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listitems[position]
        holder.des.text = currentItem.descrip
        holder.date.text = currentItem.dateTime
        holder.amount.text = currentItem.Amount
       // holder.image1.setImageResource(currentItem.image)
        holder.rate.numStars = 3
    }

    override fun getItemCount(): Int {
        return listitems.size
    }

}