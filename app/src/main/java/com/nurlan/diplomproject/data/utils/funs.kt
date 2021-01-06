package com.nurlan.diplomproject.data.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message:String){
    Toast.makeText(this.context,message, Toast.LENGTH_SHORT).show()
}