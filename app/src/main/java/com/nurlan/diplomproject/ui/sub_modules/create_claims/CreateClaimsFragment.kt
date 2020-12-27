package com.nurlan.diplomproject.ui.sub_modules.create_claims

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.databinding.FragmentCreateClaimsBinding

class CreateClaimsFragment : Fragment(R.layout.fragment_create_claims) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCreateClaimsBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentCreateClaimsBinding) = with(binding)
    {
        binding
    }
}