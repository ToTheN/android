package com.example.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.ListModel
import com.example.mvvm.R

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){
    private val listItems = mutableListOf<ListModel>()
    fun setListItems(listItems:ArrayList<ListModel>){
        this.listItems.clear()
        this.listItems.addAll(listItems)
        notifyDataSetChanged()
    }
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){


        val des:TextView = itemView.findViewById(R.id.txtView_description)
        val title:TextView = itemView.findViewById(R.id.txtView_title)
        val imgIcon:ImageView = itemView.findViewById(R.id.imgView_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(itemView)
    }
    @SuppressLint("StringFormatMatches")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listItems[position]
        holder.des.text = currentItem.description
        holder.title.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

}