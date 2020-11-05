package com.coinsboom.lucky.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coinsboom.lucky.R

class RatingFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View =
            inflater.inflate(R.layout.rating_fragment, container, false)
        return view
    }

    public fun getRatingFragment():Fragment{
        var ratingFragment = RatingFragment()
        return ratingFragment
    }
}