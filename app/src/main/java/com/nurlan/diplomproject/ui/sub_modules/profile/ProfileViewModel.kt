    package com.nurlan.diplomproject.ui.sub_modules.profile

import android.app.Application
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.models.CategoriesData
import com.nurlan.diplomproject.data.models.CitiesData
import com.nurlan.diplomproject.data.models.ClaimData
import com.nurlan.diplomproject.data.models.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(var repository: Repository): ViewModel() {
    val citiesLiveData: MutableLiveData<List<CitiesData>> = MutableLiveData()
    val categoriesLiveData: MutableLiveData<List<CategoriesData>> = MutableLiveData()

    fun getAllAts(collection: String,document: String,subCollection:String) = viewModelScope.launch{
        val response = repository.getAllAts(collection, document, subCollection)
        categoriesLiveData.value = response
    }

    fun getAllCities(collectionName: String,documentName: String) = viewModelScope.launch(Dispatchers.Main) {
        val cities = repository.getAllCities(collectionName, documentName)
            citiesLiveData.value = cities
    }

    fun getUserData(): LiveData<UserData> {
        val user = MutableLiveData<UserData>()
        val currentUser = FirebaseAuth.getInstance().currentUser?.uid
        FirebaseFirestore.getInstance().collection("cities").document("nukus").collection("users").document(currentUser!!)
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    user.value = it.result?.toObject(UserData::class.java)
                }
            }
        return user
    }
}