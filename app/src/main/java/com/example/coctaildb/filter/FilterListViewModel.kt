package com.example.coctaildb.filter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coctaildb.network.CocktailsApi
import com.example.coctaildb.network.FilterList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FilterListViewModel : ViewModel(){
    private val _filters = MutableLiveData<FilterList>()
    val filters: LiveData<FilterList>
        get() = _filters
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getFilters()
    }


    private fun getFilters(){
        coroutineScope.launch {
            val getCocktailsDeferred = CocktailsApi.RETROFIT_SERVICE.getCocktailsAsync()
            try {

            } catch (e: Exception) {
                Log.d("error", "error")
            }
        }

    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}