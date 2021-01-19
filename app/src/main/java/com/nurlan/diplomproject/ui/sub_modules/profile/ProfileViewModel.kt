    package com.nurlan.diplomproject.ui.sub_modules.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.models.CategoriesData
import com.nurlan.diplomproject.data.models.CitiesData
import com.nurlan.diplomproject.data.models.ClaimData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(var repository: Repository): ViewModel() {
    val citiesLiveData: MutableLiveData<List<CitiesData>> = MutableLiveData()
    val categoriesLiveData: MutableLiveData<List<CategoriesData>> = MutableLiveData()
    private var _claims = CategoriesData()
    private var _events = MutableLiveData<List<ClaimData>>()


    fun getAllAts(collection: String,document: String,subCollection:String) = viewModelScope.launch{
        val response = repository.getAllAts(collection, document, subCollection)
        categoriesLiveData.value = response
    }

    fun getAllCities(collectionName: String,documentName: String) = viewModelScope.launch(Dispatchers.Main) {
        val cities = repository.getAllCities(collectionName, documentName)
            citiesLiveData.value = cities
    }

    internal fun save(categoriesData: CategoriesData){

    }

    internal var categories: CategoriesData
    get() {return _claims}
    set(value) {_claims = value}

    internal var events: MutableLiveData<List<ClaimData>>
    get() {return _events}
    set(value) {_events = value}
}