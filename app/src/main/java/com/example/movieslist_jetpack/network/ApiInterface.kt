package com.example.movieslist_jetpack.network

import com.example.movieslist_jetpack.MoviesData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("movielist.json")
    suspend fun getMoviesList() : List<MoviesData>
    companion object{
        fun getInstance() : ApiInterface{
            var apiInterface : ApiInterface? = null
            if (apiInterface == null){
                apiInterface = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiInterface::class.java)
            }
            return apiInterface!!
        }
    }
}