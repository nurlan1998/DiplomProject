package com.nurlan.diplomproject.ui.sub_modules.auth

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.utils.showToast
import com.nurlan.diplomproject.databinding.FragmentAuthBinding
import java.util.concurrent.TimeUnit

class AuthFragment : Fragment(R.layout.fragment_auth) {

    private lateinit var mCallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    private lateinit var mAuth: FirebaseAuth
    private var mCodeId: String? = null

    override fun onStart() {
        super.onStart()
        mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                    if(it.isSuccessful){
                        showToast("Welcome")
                    }else showToast(it.exception?.message.toString())
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
            }

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(id, token)
                Log.i("Code",id)
                val action = AuthFragmentDirections.actionAuthFragmentToVerifyFragment(id)
                findNavController().navigate(action)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAuthBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentAuthBinding) = with(binding)
    {
        generateBtn.setOnClickListener {
            if(phoneNumberText.text.isEmpty()){
                loginFormFeedback.text = "Please fill in the form to continue."
                loginFormFeedback.visibility = View.VISIBLE
            }else{
                val phone = phoneNumberText.text.toString()
                val phoneNumber = "+998$phone"
                PhoneAuthProvider.verifyPhoneNumber(
                    PhoneAuthOptions
                        .newBuilder(FirebaseAuth.getInstance())
                        .setActivity(requireActivity())
                        .setPhoneNumber(phoneNumber)
                        .setTimeout(10, TimeUnit.SECONDS)
                        .setCallbacks(mCallback)
                        .build()
                )
                generateBtn.visibility = View.INVISIBLE
                loginProgressBar.visibility = View.VISIBLE
            }
        }
    }
}