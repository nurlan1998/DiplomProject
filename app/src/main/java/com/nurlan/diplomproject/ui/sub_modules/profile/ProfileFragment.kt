package com.nurlan.diplomproject.ui.sub_modules.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentProfileBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentProfileBinding) = with(binding)
    {

    }
}