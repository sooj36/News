package com.example.news

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.news.databinding.ActivityMainBinding
import com.example.news.fragment.DetailFragment
import com.example.news.fragment.KeepStateFragment
import com.example.news.fragment.TitleFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val titleFragment = TitleFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, titleFragment) // container == main.xml의 framelayout id
                .commit()
        }
    }

    fun showDetailFragment(news : String) {
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putString("selected_news", news)
        detailFragment.arguments = bundle

        replaceFragment(detailFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment) ////////
            .addToBackStack(null)
            .commit()
    }
}

