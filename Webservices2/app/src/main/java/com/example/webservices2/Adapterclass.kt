package com.example.webservices2

import Posts
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapterclass(private val posts: ArrayList<Posts>, val baseContext: Context): RecyclerView.Adapter<Adapterclass.MyViewHolder>(){
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val name: TextView = itemView.findViewById(R.id.name)
        val image: ImageView = itemView.findViewById(R.id.image)
        val message: TextView = itemView.findViewById(R.id.message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapterclass.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: Adapterclass.MyViewHolder, position: Int) {
        val currentItem = posts[position]
        holder.name.text = currentItem.name
        holder.message.text = currentItem.message
        val profileImgURL = currentItem.profileImage
        Picasso.with(baseContext).load(profileImgURL)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
       return posts.size
    }

}