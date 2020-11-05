package com.example.contentapp.model.NET

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfigure {
    private val retrofit =  Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }


    private val retrofitMovieCollections =  Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun<T> buildServiceCollections(service: Class<T>): T{
        return retrofitMovieCollections.create(service)
    }
}