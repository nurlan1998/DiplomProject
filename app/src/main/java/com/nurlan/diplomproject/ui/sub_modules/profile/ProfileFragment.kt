package com.nurlan.diplomproject.ui.sub_modules.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var _binding: FragmentProfileBinding? = null
    private val TAG: String = "ProfileFragment"
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var profileFactory: ProfileFactory

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = Repository()
        profileFactory = ProfileFactory(repository)
        profileViewModel = ViewModelProvider(requireActivity(),profileFactory).get(ProfileViewModel::class.java)

        profileViewModel.getUserData().observe(viewLifecycleOwner, Observer {
            if(it != null){
                binding.fragmentProfileTextFullName.text = it.firstName
                binding.fragmentProfileTextAddress.text = it.address
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}