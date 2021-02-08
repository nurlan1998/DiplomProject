package com.nurlan.diplomproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.data.models.*
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

    suspend fun getAllItemsMonter(collection0: String,document0: String,subCollection1: String,document1: String,subCollection2: String):MutableList<ClaimData>{

        val list = mutableListOf<ClaimData>()

        val result = FirebaseFirestore.getInstance()
            .collection(collection0).document(document0).collection(subCollection1)
            .document(document1).collection(subCollection2)
            .get().await()
        for(documentName in result){
            val id = documentName.getString("id")
            val name = documentName.getString("name")
            val phone = documentName.getString("phone")
            val task = documentName.getString("task")
            list.add(ClaimData(documentName.id,name, phone,"",false,task))
        }
        return list
    }
}