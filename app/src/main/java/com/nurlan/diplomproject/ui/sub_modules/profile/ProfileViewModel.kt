package com.nurlan.diplomproject.ui.sub_modules.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.models.CitiesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(var repository: Repository): ViewModel() {
    val citiesLiveData: MutableLiveData<List<CitiesData>> = MutableLiveData()

    fun getAllCities() = viewModelScope.launch {
        val cities = repository.getAllCities()
            citiesLiveData.value = cities
    }
}