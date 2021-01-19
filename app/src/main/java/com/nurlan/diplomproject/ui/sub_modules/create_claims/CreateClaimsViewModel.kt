package com.nurlan.diplomproject.ui.sub_modules.create_claims

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.models.CategoriesData
import kotlinx.coroutines.launch

class CreateClaimsViewModel(val repository: Repository): ViewModel() {
    val categoriesLiveData: MutableLiveData<List<CategoriesData>> = MutableLiveData()

    fun getAllAts(collection: String,document: String,subCollection:String) = viewModelScope.launch{
        val response = repository.getAllAts(collection, document, subCollection)
        categoriesLiveData.value = response
    }

    fun startViewModel(){
//        var categories = mutableListOf<CategoriesData>()
//        for(i in 0..20)
//        {
//            if(i==0)
//            {
//                val categorie = CategoriesData(
//                    id =i,
//                    ats = "АТС-222"
//                )
//                categories.add(categorie)
//            }
//            if(i==1)
//            {
//                val categorie = CategoriesData(
//                    id =i,
//                    ats = "АТС-223"
//                )
//                categories.add(categorie)
//            }
//            if(i==2)
//            {
//                val categorie = CategoriesData(
//                    id =i,
//                    ats = "АТС-224"
//                )
//                categories.add(categorie)
//            }
//            if(i==3)
//            {
//                val categorie = CategoriesData(
//                    id =i,
//                    ats = "АТС-225"
//                )
//                categories.add(categorie)
//            }
//            if(i==4)
//            {
//                val categorie = CategoriesData(
//                    id =i,
//                    ats = "АТС-226"
//                )
//                categories.add(categorie)
//            }
//            if(i==5)
//            {
//                val categorie = CategoriesData(
//                    id =i,
//                    ats = "АТС-227"
//                )
//                categories.add(categorie)
//            }
//            if(i==6)
//            {
//                val categorie = CategoriesData(
//                    id =i,
//                    ats = "АТС-228"
//                )
//                categories.add(categorie)
//            }
//        }
//        categoriesLiveData.value = categories
    }
}