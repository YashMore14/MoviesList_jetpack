package com.example.movieslist_jetpack.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
class ApiClient {
    var apiInterface : ApiInterface? = null
   fun getInstance() : ApiInterface{
        if (apiInterface == null){
            apiInterface = Retrofit.Builder()
                .baseUrl("https://howtodoandroid.com/apis/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiInterface::class.java)
        }
        return apiInterface!!
    }
}