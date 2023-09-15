package com.example.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.setupWithNavController
import com.example.news.databinding.ActivityMainBinding
import com.example.news.fragment.KeepStateFragment


// main.xml 의 BottomNavigation 의 지도(nav_graph.xml) 설정하고 KeepStateFragment로 만들어주는 과정
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setNavigation()
    }

    // Navigation 설정!
    private fun setNavigation() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = navHostFragment.navController

        val navigator = navHostFragment?.let { KeepStateFragment(this, it.childFragmentManager, R.id.nav_host_fragment) } // 수정

        navController.navigatorProvider.addNavigator(navigator)
        navController.setGraph(R.navigation.nav_graph)

        binding.mainNavi.setupWithNavController(navController)
    }
}

