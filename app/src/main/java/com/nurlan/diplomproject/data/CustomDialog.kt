package com.nurlan.diplomproject.data

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.adapters.CustomDialogAdapter
import com.nurlan.diplomproject.data.models.CitiesData
import com.nurlan.diplomproject.databinding.CustomDialogBinding

class CustomDialog(context: Context): Dialog(context) {

    private lateinit var mAdapter: CustomDialogAdapter
    private lateinit var binding: CustomDialogBinding
    lateinit var models:MutableList<CitiesData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CustomDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAdapter = CustomDialogAdapter()
        binding.rvCustomDialog.adapter = mAdapter
        mAdapter.models = models
    }
}