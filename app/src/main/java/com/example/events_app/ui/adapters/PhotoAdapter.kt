package com.example.events_app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.events_app.databinding.ItemPhotoBinding

class PhotoAdapter(
    private var photos: ArrayList<String>,
    private val listener: OnPhotoClickListener
): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PhotoViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo, listener)
    }

    fun updateData(photos: ArrayList<String>) {
        this.photos.clear()
        this.photos = photos
        notifyDataSetChanged()
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photo: String, listener: OnPhotoClickListener) {
            val binding = ItemPhotoBinding.bind(itemView)
            Glide.with(itemView.context)
                .load(photo)
                .into(binding.imgPhoto)
            binding.root.setOnClickListener {
                listener.onPhotoClick(photo)
            }
        }
    }

    interface OnPhotoClickListener {
        fun onPhotoClick(photo: String)
    }
}