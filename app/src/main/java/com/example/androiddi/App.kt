package com.example.androiddi

import android.app.Application
import com.example.androiddi.utils.SimpleClass
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var simpleClass: SimpleClass

    override fun onCreate() {
        super.onCreate()
//        simpleClass = SimpleClass()
        simpleClass.doSomeThing()
    }
}