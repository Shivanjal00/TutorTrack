package com.example.tutortrack.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tutortrack.data.Library
import com.example.tutortrack.databinding.ItemLibraryBinding

class LibraryAdapter(private val libraryList: List<Library>) :
    RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val binding = ItemLibraryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LibraryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val library = libraryList[position]
        holder.bind(library)
    }

    override fun getItemCount(): Int = libraryList.size

    inner class LibraryViewHolder(private val binding: ItemLibraryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(library: Library) {
            binding.libraryImage.setImageResource(library.imageResId)
            binding.libraryOwnerName.text = library.ownerName
            binding.libraryDistance.text = library.distance
            binding.libraryPrice.text = library.price
        }
    }
}
