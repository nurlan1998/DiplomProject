package com.nurlan.diplomproject.ui.sub_modules.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.models.UserData
import com.nurlan.diplomproject.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val TAG: String = "ProfileFragment"

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentUser = FirebaseAuth.getInstance().currentUser?.uid
        val db = FirebaseFirestore.getInstance()

        db.collection("cities").document("nukus").collection("users").document(currentUser!!)
            .get()
            .addOnSuccessListener {
                if(it != null){
                    val user = it.toObject(UserData::class.java)
                    binding.fragmentProfileTextFullName.text = user?.firstName + " " + user?.lastName
                    binding.fragmentProfileTextAddress.text = user?.address
                    Log.d(TAG,it.data.toString())
                }else{
                    Log.d(TAG,"no such document")
                }
            }
            .addOnFailureListener {exeption ->
                Log.d(TAG,"get failed",exeption)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}