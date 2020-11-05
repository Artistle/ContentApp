package com.coinsboom.lucky.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coinsboom.lucky.R

class MoviesFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View =
            inflater.inflate(R.layout.movie_fragment, container, false)
        return view
    }

    public fun getMovieInstance():Fragment{
        return this
    }
}