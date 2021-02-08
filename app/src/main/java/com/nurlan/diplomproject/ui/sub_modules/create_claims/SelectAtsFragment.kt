package com.nurlan.diplomproject.ui.sub_modules.create_claims

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.adapters.CategoriesAdapter
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.models.CategoriesData
import com.nurlan.diplomproject.databinding.FragmentAtsBinding
import com.nurlan.diplomproject.ui.sub_modules.profile.ProfileFactory
import com.nurlan.diplomproject.ui.sub_modules.profile.ProfileViewModel

class SelectAtsFragment : Fragment(R.layout.fragment_ats) {

//    private lateinit var createClaimsViewModel: CreateClaimsViewModel
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var mAdapter: CategoriesAdapter
    private lateinit var profileFactory: ProfileFactory
    private var TAG = "SelectAtsFragment"

    companion object{
        private var collection: String = "cities"
        private var document: String = "nukus"
        private var subCollection: String = "ats"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        val repository = Repository()
        profileFactory = ProfileFactory(repository)
        profileViewModel = ViewModelProvider(requireActivity(),profileFactory).get(ProfileViewModel::class.java)
        profileViewModel.getAllAts(collection, document, subCollection)
        profileViewModel.categoriesLiveData.observe(viewLifecycleOwner, Observer {
            mAdapter.models = it
            Log.i("Response",it.toString())
        })

        mAdapter.setItemClick {
            val action = SelectAtsFragmentDirections.actionSelectAtsFragmentToCreateClaimsFragment2(it.idName!!)
            findNavController().navigate(action)
        }
    }
}