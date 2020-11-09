package com.example.firstapp.extensions

import android.content.Context
import android.content.DialogInterface
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
//fun showToast(context:Context,message: String) {
//    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
//}

fun ImageView.loadImage(url: String, placeholder: Int = 0) {
    Glide.with(context)
        .load(url)
        .placeholder(placeholder)
        .into(this)
}

