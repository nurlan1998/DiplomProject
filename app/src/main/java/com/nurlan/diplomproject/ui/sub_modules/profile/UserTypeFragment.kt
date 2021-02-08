package com.nurlan.diplomproject.ui.sub_modules.profile

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nurlan.diplomproject.R
import com.nurlan.diplomproject.adapters.CustomDialogAdapter
import com.nurlan.diplomproject.data.CustomDialog
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.models.CitiesData
import com.nurlan.diplomproject.data.utils.showToast
import com.nurlan.diplomproject.databinding.FragmentUserTypeBinding
import com.nurlan.diplomproject.ui.sub_modules.base.ShareViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserTypeFragment : Fragment(R.layout.fragment_user_type) {

    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var profileFactory: ProfileFactory
    private val shareViewModel: ShareViewModel by activityViewModels()
    private val collectionName = "cities"
    private val documentName = "name"

    companion object{
        const val SUBSCRIBER = "subscriber"
        const val FITTER = "fitter"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentUserTypeBinding.bind(view)
        setup(binding)
        var dialog = CustomDialog(requireContext())
        dialog.mAdapter = CustomDialogAdapter()
        val repository = Repository()
        profileFactory = ProfileFactory(repository)
        profileViewModel = ViewModelProvider(requireActivity(),profileFactory).get(ProfileViewModel::class.java)
        profileViewModel.getAllCities(collectionName, documentName)
        profileViewModel.citiesLiveData.observe(viewLifecycleOwner, Observer {
            Log.i("Cities",it.toString())
            dialog.models = it as MutableList<CitiesData>
            dialog.setTitle("Выберите ваш город или район")
            dialog.setCancelable(false)
            dialog.show()
        })
    }

    override fun onResume() {
        super.onResume()
//        createAlertDialog(requireContext())
    }

    private fun createAlertDialog(context: Context)
    {
        val dialog = Dialog(context)
        val adapter = CustomDialogAdapter()

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.custom_dialog)
    }

    private fun setup(binding: FragmentUserTypeBinding) = with(binding)
    {
        btnSubscriber.setOnClickListener {
            shareViewModel.updateData(SUBSCRIBER)
            findNavController().navigate(R.id.action_userTypeFragment_to_authFragment)
        }
        btnFitter.setOnClickListener {
            shareViewModel.updateData(FITTER)
            findNavController().navigate(R.id.action_userTypeFragment_to_authFragment)
        }
    }
}