package com.nurlan.diplomproject.data.models

data class CategoriesData(
//        val id: Int,
        var idName: String? = "222",
        var atsName: String? = "АТС-222"
){
        private var _claims: MutableList<ClaimData> = mutableListOf()

        var claims: MutableList<ClaimData>
        get() {return _claims}
        set(value) {_claims = value}
}