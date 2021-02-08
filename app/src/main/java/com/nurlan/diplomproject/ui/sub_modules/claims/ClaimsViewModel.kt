package com.nurlan.diplomproject.ui.sub_modules.claims

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nurlan.diplomproject.data.models.ClaimData

class ClaimsViewModel: ViewModel() {
    val claimsLiveData: MutableLiveData<List<ClaimData>> = MutableLiveData()

    fun startViewModel(){
        val claims = mutableListOf<ClaimData>()

        for(i in 0..5)
        {
            if(i==0) {
                val claim = ClaimData(
                    id = i.toString(),
                    name = "nurlan",
                    phone = "+998999563884",
                    image = "",
                    task = "проблемы с модемом не подключается к интернету нужен монтер"
                )
                claims.add(claim)
            }
            if(i==1) {
                val claim = ClaimData(
                    id = i.toString(),
                    name = "nurlan",
                    phone = "+998999563884",
                    image = "",
                    task = "проблемы с модемом не подключается к интернету нужен монтер"
                )
                claims.add(claim)
            }
            if(i==2) {
                val claim = ClaimData(
                    id = i.toString(),
                    name = "nurlan",
                    phone = "+998999563884",
                    image = "",
                    task = "проблемы с модемом не подключается к интернету нужен монтер"
                )
                claims.add(claim)
            }
        }
        claimsLiveData.value = claims
    }
}