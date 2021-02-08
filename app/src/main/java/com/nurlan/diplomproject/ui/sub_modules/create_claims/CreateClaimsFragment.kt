package com.nurlan.diplomproject.ui.sub_modules.create_claims

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.models.CategoriesData
import com.nurlan.diplomproject.data.models.ClaimData
import com.nurlan.diplomproject.data.utils.showToast
import com.nurlan.diplomproject.databinding.FragmentCreateClaimsBinding
import com.nurlan.diplomproject.ui.sub_modules.base.ShareViewModel
import com.nurlan.diplomproject.ui.sub_modules.profile.ProfileFactory
import com.nurlan.diplomproject.ui.sub_modules.profile.ProfileViewModel

class CreateClaimsFragment : Fragment(R.layout.fragment_create_claims) {

    private lateinit var profileFactory: ProfileFactory
    private lateinit var profileViewModel: ProfileViewModel
//    private lateinit var shareViewModel: ShareViewModel
    private val model: ShareViewModel by activityViewModels()
    private var claims = ClaimData()
    private val args: CreateClaimsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCreateClaimsBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentCreateClaimsBinding) = with(binding)
    {
        val repository = Repository()
        profileFactory = ProfileFactory(repository)
        profileViewModel =
            ViewModelProvider(requireActivity(), profileFactory).get(ProfileViewModel::class.java)
//        shareViewModel = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)

        fragmentCreateClaimsButtonPlace.setOnClickListener{
            var name = fragmentCreateClaimsEditTextFullName.text.toString()
            var address = fragmentCreateClaimsEditTextAddress.text.toString()
            var phone = fragmentCreateClaimsEditTextPhone.text.toString()
            var task = fragmentCreateClaimsEditTextTask.text.toString()
            val db = FirebaseFirestore.getInstance()

            var document = db.collection("cities").document("nukus")
                .collection("ats").document("222").collection("222").document()

            showToast(document.id)

            claims = ClaimData("",name, phone, "", false, task)
            save(claims)
        }
    }

    fun save(claimData: ClaimData){
        val db = FirebaseFirestore.getInstance()
        db.collection("cities").document("nukus").collection("ats")
            .document(args.idAts).collection(args.idAts)
            .add(claims).addOnSuccessListener {
            }
    }
}