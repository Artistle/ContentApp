package com.coinsboom.lucky.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelProviders.of
import androidx.lifecycle.ViewModelStores.of
import com.coinsboom.lucky.R
import com.coinsboom.lucky.viewModel.LoadMovieCollections


class FavoritesFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View =
            inflater.inflate(R.layout.favorites_fragment, container, false)
        val loadCollectionsMovie:LoadMovieCollections
        loadCollectionsMovie = ViewModelProviders.of(this).get(LoadMovieCollections::class.java)
        loadCollectionsMovie.loadCollections()
        loadCollectionsMovie.liveDataCollectionsMovie.observe(viewLifecycleOwner, Observer{
            var l = it
            var f = "s"
        })

        return view
    }

    public fun getFavoritesFragment():Fragment{
        return this
    }
}