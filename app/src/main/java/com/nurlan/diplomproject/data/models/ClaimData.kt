package com.nurlan.diplomproject.data.models

data class ClaimData(
        var id: String? = "",
        var name:String? = "",
        var phone: String? = "",
        var image: String? = "",
        var selectClaim: Boolean = false,
        var task: String? = ""
)