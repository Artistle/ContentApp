package com.coinsboom.lucky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.coinsboom.lucky.view.fragments.FavoritesFragment
import com.coinsboom.lucky.view.fragments.MoviesFragment
import com.coinsboom.lucky.view.fragments.RatingFragment
import com.coinsboom.lucky.viewModel.LoadMovie
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentTransaction:FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var loadMovie: LoadMovie
        loadMovie = ViewModelProviders.of(this@MainActivity).get(LoadMovie::class.java)
        loadMovie.loadVerboseMovie()
        loadMovie.liveDataMovie.observe(this,Observer{
        })

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.main_bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.rating_item -> {
                    Toast.makeText(this,"rating",Toast.LENGTH_LONG).show()
                    loadFragment(RatingFragment().getRatingFragment())
                    true
                }
                R.id.favorites_item -> {
                    Toast.makeText(this,"favorites",Toast.LENGTH_LONG).show()
                    loadFragment(FavoritesFragment().getFavoritesFragment())
                    true
                }
                R.id.movie_item -> {
                    Toast.makeText(this,"movie",Toast.LENGTH_LONG).show()
                    loadFragment(MoviesFragment().getMovieInstance())
                    true
                }
                else -> false
            }
        }
    }

    fun loadFragment(fragment:Fragment){
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout_main,fragment)
        fragmentTransaction.commit()
    }
}