package com.example.androiddi.utils

import android.util.Log
import javax.inject.Inject

class SimpleClass @Inject constructor() {
    fun doSomeThing() {
        Log.d("@@@", "doSomeThing: is working ")
    }
}