package com.nurlan.diplomproject.ui.sub_modules.monter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.adapters.MonterAdapter
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.utils.showToast
import com.nurlan.diplomproject.databinding.FragmentMonterBinding


class MonterFragment : Fragment() {
    private var _binding:FragmentMonterBinding? = null
    private val mBinding  get() = _binding!!
    private lateinit var mAdapter:MonterAdapter
    private lateinit var monterViewModel: MonterViewModel
    private lateinit var monterFactroy: MonterFactroy

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMonterBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAdapter = MonterAdapter()
        mBinding.monterRecyclerView.adapter = mAdapter

        getItems()
    }

    private fun getItems() {
        val repository = Repository()
        monterFactroy = MonterFactroy(repository)
        monterViewModel = ViewModelProvider(requireActivity(),monterFactroy).get(MonterViewModel::class.java)
        monterViewModel.getAllItemsMonter("cities","nukus","ats","222","222")
        monterViewModel.monterLiveData.observe(viewLifecycleOwner, Observer {
            mAdapter.model = it
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}