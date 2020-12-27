package com.nurlan.diplomproject.ui.sub_modules.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.databinding.FragmentSetProfileBinding

class SetProfileFragment : Fragment(R.layout.fragment_set_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSetProfileBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentSetProfileBinding) = with(binding)
    {
        var fullName = fragmentSetProfileEditTextFullName.toString()
        var name = fragmentSetProfileEditTextName

        fragmentSetProfileButtonSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_setProfileFragment_to_mainActivity)
        }
    }
}