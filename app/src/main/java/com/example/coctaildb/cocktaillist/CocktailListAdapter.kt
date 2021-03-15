package com.example.coctaildb.cocktaillist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coctaildb.databinding.CocktailItemBinding
import com.example.coctaildb.network.Cocktail


class CocktailListAdapter :
    ListAdapter<Cocktail, CocktailListAdapter.CocktailListViewHolder>(DiffCallback) {


    class CocktailListViewHolder(private var binding: CocktailItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cocktail: Cocktail) {
            binding.cocktail = cocktail
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailListViewHolder {
        return CocktailListViewHolder(CocktailItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CocktailListViewHolder, position: Int) {
        val cocktail = getItem(position)
        holder.bind(cocktail)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Cocktail>() {
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem.id == newItem.id
        }
    }
}