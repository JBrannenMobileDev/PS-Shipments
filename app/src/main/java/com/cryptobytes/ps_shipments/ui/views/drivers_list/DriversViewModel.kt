package com.cryptobytes.ps_shipments.ui.views.drivers_list

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.cryptobytes.ps_shipments.data.model.Assignment
import com.cryptobytes.ps_shipments.data.Driver

class DriversViewModel : ViewModel() {
    private val apiService = MovieApiClient.service
    private lateinit  var repository:MovieRepository

    var trendingMovies:List<Assignment> by mutableStateOf(listOf())

    lateinit var clickedItem :MovieItem

    init {
        fetchTrendingMovies()
    }

    fun fetchTrendingMovies(){

        repository = MovieRepository(apiService)
        viewModelScope.launch {
            var response = repository.fetchTrendingMovies()
            when(response){
                is MovieRepository.Result.Success -> {

                    Log.d("TAG","TEST")
                    trendingMovies = response.movieList
                }
                is MovieRepository.Result.Failure ->{
                    Log.d("MainViewModel","FAILURE")
                }
            }
        }
    }

    fun itemClicked(item:Driver){
        clickedItem = item
    }
}