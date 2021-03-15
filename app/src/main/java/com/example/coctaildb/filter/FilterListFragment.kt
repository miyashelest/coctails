package com.example.coctaildb.filter

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coctaildb.R
import com.example.coctaildb.cocktaillist.CocktailListAdapter
import com.example.coctaildb.cocktaillist.CocktailListViewModel
import com.example.coctaildb.databinding.CocktailListFragmentBinding
import com.example.coctaildb.databinding.FiltersFragmentBinding

class FilterListFragment : Fragment() {
    private val viewModel: FilterListViewModel by lazy {
        ViewModelProvider(this).get(FilterListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FiltersFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        binding.filter = viewModel

        return binding.root
    }
}