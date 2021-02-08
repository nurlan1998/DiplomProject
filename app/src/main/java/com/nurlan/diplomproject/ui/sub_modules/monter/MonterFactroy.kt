package com.nurlan.diplomproject.ui.sub_modules.monter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nurlan.diplomproject.data.Repository

class MonterFactroy(val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MonterViewModel(repository) as T
    }
}