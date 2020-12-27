package com.nurlan.diplomproject.ui.sub_modules.create_claims

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.adapters.CategoriesAdapter
import com.nurlan.diplomproject.databinding.FragmentAtsBinding

class SelectAtsFragment : Fragment(R.layout.fragment_ats) {

    private lateinit var createClaimsViewModel: CreateClaimsViewModel
    private lateinit var mAdapter: CategoriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createClaimsViewModel = ViewModelProvider(requireActivity()).get(CreateClaimsViewModel::class.java)
        createClaimsViewModel.startViewModel()
        createClaimsViewModel.categoriesLiveData.observe(viewLifecycleOwner, Observer {
            mAdapter.models = it
        })

        val binding = FragmentAtsBinding.bind(view)
        setup(binding)
    }

    private fun setup(binding: FragmentAtsBinding) = with(binding)
    {
        mAdapter = CategoriesAdapter()
        rvCategories.adapter = mAdapter
        var divider = DividerItemDecoration(requireContext(),LinearLayoutManager.HORIZONTAL)
        rvCategories.addItemDecoration(divider)
        val layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.rvCategories.layoutManager = layoutManager
    }
}