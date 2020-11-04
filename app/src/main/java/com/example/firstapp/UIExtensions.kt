package com.example.firstapp

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
//fun showToast(context:Context,message: String) {
//    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
//}