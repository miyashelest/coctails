package com.example.coctaildb.filter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coctaildb.databinding.FilterItemBinding
import com.example.coctaildb.network.Filter

class FilterListAdapter :
    ListAdapter<Filter, FilterListAdapter.FilterListViewHolder>(DiffCallback) {


    class FilterListViewHolder(private var binding: FilterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(filter: Filter) {
            binding.filter = filter
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterListViewHolder {
        return FilterListViewHolder(FilterItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FilterListAdapter.FilterListViewHolder, position: Int) {
        val filter = getItem(position)
        holder.bind(filter)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Filter>() {
        override fun areItemsTheSame(oldItem: Filter, newItem: Filter): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Filter, newItem: Filter): Boolean {
            return oldItem.filter == newItem.filter
        }

    }


}