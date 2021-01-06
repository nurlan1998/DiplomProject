package com.nurlan.diplomproject.ui.sub_modules.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.utils.showToast
import com.nurlan.diplomproject.databinding.FragmentVerifyBinding

class VerifyFragment : Fragment(R.layout.fragment_verify) {

    private val args: VerifyFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentVerifyBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentVerifyBinding) = with(binding)
    {
        verifyBtn.setOnClickListener {
            val code = otpTextView.text.toString()
            val credential = PhoneAuthProvider.getCredential(args.id,code)
            FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                if(it.isSuccessful){
                    showToast("Welcome")
                    findNavController().navigate(R.id.action_verifyFragment_to_setProfileFragment)
                }
            }
        }
    }
}