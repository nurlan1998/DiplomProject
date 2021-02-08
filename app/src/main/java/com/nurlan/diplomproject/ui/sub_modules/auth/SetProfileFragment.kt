package com.nurlan.diplomproject.ui.sub_modules.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.utils.showToast
import com.nurlan.diplomproject.databinding.FragmentSetProfileBinding
import com.nurlan.diplomproject.ui.sub_modules.base.ShareViewModel
import com.nurlan.diplomproject.ui.sub_modules.profile.UserTypeFragment.Companion.FITTER
import com.nurlan.diplomproject.ui.sub_modules.profile.UserTypeFragment.Companion.SUBSCRIBER

class SetProfileFragment : Fragment(R.layout.fragment_set_profile) {

    private var _binding: FragmentSetProfileBinding? = null

    private val binding get() = _binding!!

    private val shareViewModel: ShareViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSetProfileBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup()
    {
        binding.fragmentSetProfileButtonSignIn.setOnClickListener {
            val name = binding.fragmentSetProfileEditTextFullName.text.toString()
            val lastName = binding.fragmentSetProfileEditTextName.text.toString()
            val address = binding.fragmentSetProfileEditTextAddress.text.toString()

            val currentUser = FirebaseAuth.getInstance().currentUser?.uid
            val db = FirebaseFirestore.getInstance()
            val user: MutableMap<String, Any> = HashMap()
            user["firstName"] = name
            user["lastName"] = lastName
            user["address"] = address

            db.collection("cities").document("nukus").collection("users").document(currentUser!!)
                .set(user).addOnSuccessListener {
                    showToast("Success")
                    shareViewModel.dataToShare.observe(viewLifecycleOwner, Observer {
                        if(it == SUBSCRIBER){
                            findNavController().navigate(R.id.action_setProfileFragment_to_mainActivity)
                        }else{
                            if(it == FITTER){
                                findNavController().navigate(R.id.action_setProfileFragment_to_monterFragment)
                            }
                        }
                    })
                }
                .addOnFailureListener {
                    showToast("Error")
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}