package ru.glabrion.ciceroneapp.common

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

fun getProgressBar(context: Context): CircularProgressDrawable {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    return circularProgressDrawable
}