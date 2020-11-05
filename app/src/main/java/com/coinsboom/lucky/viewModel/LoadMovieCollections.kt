package com.coinsboom.lucky.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contentapp.model.NET.RetrofitConfigure
import com.example.contentapp.model.NET.RetrofitRequest
import com.coinsboom.lucky.model.movieCollectionsModel.MovieCollections
import com.example.contentapp.model.movieModel.DateClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadMovieCollections: ViewModel() {
    val liveDataCollectionsMovie = MutableLiveData<MovieCollections>()

    fun loadCollections(){
        val request = RetrofitConfigure.buildServiceCollections(RetrofitRequest::class.java)
        val call = request.getCollectionsMovie()
        call.enqueue(object: Callback<MovieCollections> {
            override fun onFailure(call: Call<MovieCollections>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MovieCollections>,
                response: Response<MovieCollections>
            ) {
                liveDataCollectionsMovie.setValue(response.body())
                var t = "s"
            }


        })
    }
}