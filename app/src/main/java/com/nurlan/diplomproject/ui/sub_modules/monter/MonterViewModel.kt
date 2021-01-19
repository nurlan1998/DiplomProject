package com.nurlan.diplomproject.ui.sub_modules.monter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nurlan.diplomproject.data.Repository
import com.nurlan.diplomproject.data.models.MonterData
import kotlinx.coroutines.launch

class MonterViewModel(var repository: Repository):ViewModel() {

    val monterLiveData:MutableLiveData<List<MonterData>> = MutableLiveData()

       fun getAllItemsMonter(collection0: String,document0:String,subCollection1:String,
                             document1:String,subCollection2:String) = viewModelScope.launch {

           monterLiveData.value = repository.getAllItemsMonter(collection0 = collection0,document0 = document0,
           subCollection1 = subCollection1,document1 = document1,subCollection2 = subCollection2)
       }

}