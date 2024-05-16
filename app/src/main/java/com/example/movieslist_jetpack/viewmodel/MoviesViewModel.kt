package com.example.movieslist_jetpack.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieslist_jetpack.MoviesData
import com.example.movieslist_jetpack.network.ApiClient
import com.example.movieslist_jetpack.network.ApiInterface
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    var moviesListRes : List<MoviesData> by mutableStateOf(listOf())
    var errormsg : String by mutableStateOf("")
    fun getMovies(){
        viewModelScope.launch {
            val apiClient = ApiClient()
            val apService = apiClient.getInstance()
            try {
                val moviesList = apService.getMoviesList()
                moviesListRes = moviesList
            }catch (e: Exception){
                errormsg = e.message!!
            }
        }
    }
}