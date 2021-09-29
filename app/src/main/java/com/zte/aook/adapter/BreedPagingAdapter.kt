package com.zte.aook.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.zte.aook.R
import com.zte.aook.data.Breed
import com.zte.aook.util.ImageLoadUtils

class BreedPagingAdapter(val mContext:Context):PagingDataAdapter<Breed,BreedPagingAdapter.BreedViewHolder>(mDiff) {
    val TAG:String = "BreedPagingAdapter"

    companion object{
        val mDiff = object : DiffUtil.ItemCallback<Breed>(){
            override fun areItemsTheSame(oldItem: Breed, newItem: Breed): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Breed, newItem: Breed): Boolean {
                return oldItem==newItem
            }

        }
    }

    class BreedViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val icons:ImageView = itemView.findViewById(R.id.breed_icons)
        val name:TextView = itemView.findViewById(R.id.breed_name)
        val description:TextView = itemView.findViewById(R.id.breed_description)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        Log.i(TAG," onCreateViewHolder position=${position}")
        val response = getItem(position)
        if (response!=null){
            ImageLoadUtils.display(mContext,holder.icons,response.image.url)
            holder.name.text = response.name
            holder.description.text = response.temperament
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        Log.i(TAG," onCreateViewHolder ")
        val view = LayoutInflater.from(mContext).inflate(R.layout.breed_item_view,parent,false)
        return BreedViewHolder(view)
    }

}
