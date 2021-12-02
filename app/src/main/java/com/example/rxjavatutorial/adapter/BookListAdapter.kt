package com.example.rxjavatutorial.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavatutorial.data.VolumeInfo
import com.example.rxjavatutorial.databinding.ItemBookBinding

class BookListAdapter: ListAdapter<VolumeInfo, BookListAdapter.BookItemViewHolder>(diffUtil) {

    inner class BookItemViewHolder(private val binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(volumeInfo: VolumeInfo) {
            binding.volumeInfo = volumeInfo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        return BookItemViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<VolumeInfo>() {
            override fun areItemsTheSame(oldItem: VolumeInfo, newItem: VolumeInfo): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: VolumeInfo, newItem: VolumeInfo): Boolean {
                return oldItem == newItem
            }

        }
    }
}