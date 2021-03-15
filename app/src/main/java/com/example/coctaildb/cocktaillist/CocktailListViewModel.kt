package com.example.coctaildb.cocktaillist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coctaildb.network.CocktailsApi
import com.example.coctaildb.network.CocktailsList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CocktailListViewModel : ViewModel() {
    private val _cocktails = MutableLiveData<CocktailsList>()
    val cocktails: LiveData<CocktailsList>
        get() = _cocktails

    private val _navigateToFilterList = MutableLiveData<CocktailsList>()
    val navigateToFilterList
    get() = _navigateToFilterList
    fun onToFilterClicked(){
        _navigateToFilterList.value = null
    }
    fun onFilterNavigated(){
        _navigateToFilterList.value = null
    }

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getCocktails()
    }

    private fun getCocktails() {
        coroutineScope.launch {
            val getCocktailsDeferred = CocktailsApi.RETROFIT_SERVICE.getCocktailsAsync()
            try {
                val result = getCocktailsDeferred.await()
                _cocktails.value = result
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