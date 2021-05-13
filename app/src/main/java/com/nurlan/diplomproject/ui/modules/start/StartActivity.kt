package com.nurlan.diplomproject.ui.modules.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.databinding.ActivityStartBinding
import com.nurlan.diplomproject.ui.modules.main.MainActivity

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this,R.id.activity_start_nav_container)
    }

    override fun onStart() {
        super.onStart()
        FirebaseAuth.getInstance().addAuthStateListener {
            if(it.currentUser == null){
            }else{
                openMainGraph()
                finish()
            }
        }
    }

    fun openSetProfileFragment(){
//        navController.navigate(R.id.)
    }

    fun openMainGraph(){
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}