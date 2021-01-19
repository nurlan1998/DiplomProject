package com.nurlan.diplomproject.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.data.models.CategoriesData
import com.nurlan.diplomproject.data.models.CitiesData
import com.nurlan.diplomproject.data.models.UserData
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class Repository {
    private lateinit var auth: FirebaseAuth
    private val firestore = FirebaseFirestore.getInstance()

    suspend fun getAllCities(collectionName: String,documentName: String): MutableList<CitiesData>{
        val eventList = mutableListOf<CitiesData>()
        val resultList = FirebaseFirestore.getInstance()
                .collection(collectionName)
                .get().await()
        for(document in resultList){
            val name = document.getString(documentName)
            eventList.add(CitiesData(name!!))
        }
        return eventList
    }

    suspend fun getAllAts(collection: String,document: String,subCollection: String): MutableList<CategoriesData>{
        val list = mutableListOf<CategoriesData>()
        val resultList = FirebaseFirestore.getInstance()
            .collection(collection).document(document).collection(subCollection)
            .get().await()
        for(documentName in resultList){
//            val id = document.getString("id")?.toInt()
            val idName = documentName.getString("idName")
            val name = documentName.getString("atsName")
            list.add(CategoriesData(idName!!,name!!))
        }
        return list
    }
}