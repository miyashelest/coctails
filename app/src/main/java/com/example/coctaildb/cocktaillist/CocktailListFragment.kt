package com.example.coctaildb.cocktaillist

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.coctaildb.R
import com.example.coctaildb.databinding.CocktailListFragmentBinding

class CocktailListFragment : Fragment() {

    private val viewModel: CocktailListViewModel by lazy {
        ViewModelProvider(this).get(CocktailListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = CocktailListFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.cocktail = viewModel
        binding.cocktailList.adapter = CocktailListAdapter()
        setHasOptionsMenu(true)
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.filterListFragment -> {

                }
            }
            false
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}