package com.example.coctaildb

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coctaildb.cocktaillist.CocktailListAdapter
import com.example.coctaildb.filter.FilterListAdapter
import com.example.coctaildb.network.CocktailsList
import com.example.coctaildb.network.FilterList
import com.squareup.picasso.Picasso

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: CocktailsList?) {
    val adapter = recyclerView.adapter as CocktailListAdapter
    adapter.submitList(data?.list)
}


@BindingAdapter("filterList")
fun bindRecyclerView1(recyclerView: RecyclerView, data: FilterList?) {
    val adapter = recyclerView.adapter as FilterListAdapter
    adapter.submitList(data?.list)
}

@BindingAdapter("strDrinkThumb")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Picasso.get()
            .load(imgUri)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .into(imgView)
    }
}