package com.example.recyclerview2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.ListModel


class CustomAdapter(private val listitems: MutableList<ListModel>, private val context: Context):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
        const val VIEW_FAVORITE_ITEM = 2
        const val VIEW_OFFER_IMAGE = 3
        const val VIEW_TEXT_MESSAGE = 1
    }

       inner class MessageTextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
           private var textviewrestaurent: TextView = itemView.findViewById(R.id.textview_avail_offer)
           fun updateData(favorite:ListModel) {
               textviewrestaurent.text = favorite.restaurent
           }
       }

       inner class OfferImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
           private var imageviewOffer: ImageView = itemView.findViewById(R.id.imageview_offer)
           fun updateData(favorite: ListModel) {
               favorite.foodImage.let { imageviewOffer.setImageResource(it) }
           }
       }

       inner class ImageTextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
           private var textviewRestaurant: TextView = itemView.findViewById(R.id.textview_restaurant)
           private var imageviewFood: ImageView = itemView.findViewById(R.id.imageview_food_image)
           fun updateData(favorite: ListModel) {
               textviewRestaurant.text = favorite.restaurent
               favorite.foodImage.let { imageviewFood.setImageResource(it) }
           }
       }





    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder?
        val inflater = LayoutInflater.from(viewGroup.context)
        when (viewType) {
            VIEW_FAVORITE_ITEM -> {
                val v1: View = inflater.inflate(R.layout.item_image_text_offer, viewGroup, false)
                viewHolder = ImageTextViewHolder(v1)
            }
            VIEW_OFFER_IMAGE -> {
                val v2: View = inflater.inflate(R.layout.item_image_offer, viewGroup, false)
                viewHolder = OfferImageViewHolder(v2)

               // val v3: View = inflater.inflate(R.layout.item_text_offer, viewGroup, false)
                //viewHolder = MessageTextViewHolder(v3)
            }
            VIEW_TEXT_MESSAGE -> {
                val v2: View = inflater.inflate(R.layout.item_text_offer, viewGroup, false)
                viewHolder = MessageTextViewHolder(v2)
            }
            else -> {
                val v1: View = inflater.inflate(R.layout.item_image_text_offer, viewGroup, false)
                viewHolder = ImageTextViewHolder(v1)
            }
        }
        return viewHolder!!
    }


    override fun getItemCount(): Int {
        return listitems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
        when (holder.getItemViewType()) {
            VIEW_FAVORITE_ITEM -> {
                val oIVH = holder as ImageTextViewHolder
                oIVH.updateData(listitems.get(position))
            }
            VIEW_OFFER_IMAGE -> {
                val oIVH = holder as OfferImageViewHolder
                oIVH.updateData(listitems.get(position))
            }
            else -> {
                val mTVH: MessageTextViewHolder = holder as MessageTextViewHolder
                mTVH.updateData(listitems.get(position))
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        if (listitems.get(position).type == 1) {
            return VIEW_TEXT_MESSAGE
        } else if (listitems.get(position).type == 2) {
            return VIEW_FAVORITE_ITEM
        } else if (listitems.get(position).type == 3) {
            return VIEW_OFFER_IMAGE
        }
        return -1
    }



}