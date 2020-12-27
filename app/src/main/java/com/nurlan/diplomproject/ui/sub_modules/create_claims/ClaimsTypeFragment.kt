package com.nurlan.diplomproject.ui.sub_modules.create_claims

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.databinding.FragmentClaimsTypeBinding

class ClaimsTypeFragment : Fragment(R.layout.fragment_claims_type) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentClaimsTypeBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentClaimsTypeBinding) = with(binding)
    {
        fragmentSelectAtsTvModem.setOnClickListener {
            findNavController().navigate(R.id.action_claimsTypeFragment_to_selectAtsFragment)
        }

        fragmentSelectAtsTvTelephone.setOnClickListener {
            findNavController().navigate(R.id.action_claimsTypeFragment_to_selectAtsFragment)
        }

        fragmentSelectAtsIpTv.setOnClickListener {
            findNavController().navigate(R.id.action_claimsTypeFragment_to_selectAtsFragment)
        }
    }
}