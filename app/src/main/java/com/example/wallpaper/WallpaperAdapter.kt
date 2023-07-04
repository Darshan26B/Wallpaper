package com.example.wallpaper

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.wallpaper.databinding.WplayoutBinding

class WallpaperAdapter : RecyclerView.Adapter<WallpaperAdapter.WpHolder>() {
    lateinit var context: Context
     var photos= ArrayList<PhotosItem>()

    class WpHolder(itemView: WplayoutBinding) : ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WpHolder {
        context=parent.context
        var binding = WplayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WpHolder(binding)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: WpHolder, position: Int) {
        holder.binding.apply {
            photos.get(position)?.src?.apply {
                Glide.with(context).load(portrait).into(image)
            }
        }
    }

    fun setphotos(photos: List<PhotosItem?>?) {
        this.photos = photos as ArrayList<PhotosItem>

    }
}