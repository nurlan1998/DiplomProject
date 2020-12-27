package com.nurlan.diplomproject.ui.modules.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this,R.id.activity_main_nav_container)

        setupNavigation()
    }

    private fun setupNavigation()
    {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.activity_main_nav_container) as NavHostFragment?
        NavigationUI.setupWithNavController(binding.btmNavView,navHostFragment!!.navController)
    }
}