package com.nurlan.diplomproject.ui.sub_modules.claims

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.adapters.ClaimsAdapter
import com.nurlan.diplomproject.databinding.FragmentClaimsBinding

class ClaimsFragment : Fragment(R.layout.fragment_claims) {

    private lateinit var mClaimViewModel: ClaimsViewModel
    private lateinit var mAdapter: ClaimsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = ClaimsAdapter()

        mClaimViewModel = ViewModelProvider(requireActivity()).get(ClaimsViewModel::class.java)
        mClaimViewModel.startViewModel()
        mClaimViewModel.claimsLiveData.observe(viewLifecycleOwner, Observer {
            mAdapter.models = it
            Log.i("Response",it.toString())
        })

        val binding = FragmentClaimsBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentClaimsBinding) = with(binding)
    {
        rvClaims.adapter = mAdapter
        var layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        rvClaims.layoutManager = layoutManager
        var divider = DividerItemDecoration(requireContext(),LinearLayoutManager.HORIZONTAL)
        rvClaims.addItemDecoration(divider)
    }
}