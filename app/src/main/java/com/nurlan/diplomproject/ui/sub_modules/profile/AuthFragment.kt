package com.nurlan.diplomproject.ui.sub_modules.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.databinding.FragmentAuthBinding

class AuthFragment : Fragment(R.layout.fragment_auth) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAuthBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentAuthBinding) = with(binding)
    {
        var phone = fragmentAuthEditTextPhone.toString()
        fragmentAuthBtnSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_setProfileFragment)
        }
    }
}