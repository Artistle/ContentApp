package com.example.contentapp.model.NET

import com.example.contentapp.model.movieModel.DateClass
import com.coinsboom.lucky.model.movieCollectionsModel.MovieCollections
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitRequest {
    @GET("movie/558?api_key=6ce6ba48326102af3c6fa56d9873fbc3&language=ru-RU")
    fun getMovies():Call<DateClass>

    @GET("collection/1010?api_key=6ce6ba48326102af3c6fa56d9873fbc3&language=ru-RU")
    fun getCollectionsMovie():Call<MovieCollections>
}