package com.nurlan.diplomproject.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.nurlan.diplomproject.data.models.CitiesData
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class Repository {
    private lateinit var auth: FirebaseAuth
    private val firestore = FirebaseFirestore.getInstance()
    private val citiesCollection = firestore.collection("cities")

    suspend fun getAllCities(): MutableList<CitiesData>{
//        return try {
//            citiesCollection.get().await().toObjects(CitiesData::class.java)
//        }catch (e: Exception){
//            emptyList()
//        }
        val eventList = mutableListOf<CitiesData>()
        val resultList = FirebaseFirestore.getInstance()
                .collection("cities")
                .get().await()
        for(document in resultList){
            val name = document.getString("name")
            eventList.add(CitiesData(name!!))
        }
        return eventList
    }
}