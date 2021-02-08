package com.nurlan.diplomproject.ui.sub_modules.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel: ViewModel() {
    val dataToShare = MutableLiveData<String>()

    fun updateData(data: String) {
        dataToShare.value = data
    }
}