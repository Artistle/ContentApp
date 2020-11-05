package com.coinsboom.lucky.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contentapp.model.movieModel.DateClass
import com.example.contentapp.model.NET.RetrofitConfigure
import com.example.contentapp.model.NET.RetrofitRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadMovie:ViewModel() {
    val liveDataMovie = MutableLiveData<DateClass>()
    fun loadVerboseMovie(){
        val request = RetrofitConfigure.buildService(RetrofitRequest::class.java)
        val call = request.getMovies()
        call.enqueue(object: Callback<DateClass> {
            override fun onFailure(call: Call<DateClass>, t: Throwable) {

            }

            override fun onResponse(call: Call<DateClass>, response: Response<DateClass>) {
                liveDataMovie.setValue(response.body())

            }

        })
    }
}