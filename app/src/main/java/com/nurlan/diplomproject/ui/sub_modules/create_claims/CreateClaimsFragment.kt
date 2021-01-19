package com.nurlan.diplomproject.ui.sub_modules.create_claims

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.models.CategoriesData
import com.nurlan.diplomproject.data.models.ClaimData
import com.nurlan.diplomproject.databinding.FragmentCreateClaimsBinding
import com.nurlan.diplomproject.ui.sub_modules.profile.ProfileFactory
import com.nurlan.diplomproject.ui.sub_modules.profile.ProfileViewModel

class CreateClaimsFragment : Fragment(R.layout.fragment_create_claims) {

    private lateinit var profileFactory: ProfileFactory
    private lateinit var profileViewModel: ProfileViewModel
    private var claims = ClaimData()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCreateClaimsBinding.bind(view)
        setup(binding)
    }

    override fun onResume() {
        super.onResume()
        claims = ClaimData(2,"nurlan","+998999563884","","")
    }

    private fun setup(binding: FragmentCreateClaimsBinding) = with(binding)
    {
        val repository = Repository()
        profileFactory = ProfileFactory(repository)
        profileViewModel = ViewModelProvider(requireActivity(),profileFactory).get(ProfileViewModel::class.java)

        fragmentCreateClaimsButtonPlace.setOnClickListener {
            val db = FirebaseFirestore.getInstance()
            FirebaseFirestore.getInstance().collection("cities").document("nukus").collection("ats")
                .document("222").collection("222")
                .add(claims)
        }
    }
}