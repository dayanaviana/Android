package com.android_training.class28.login

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        MyApplication.appContext = applicationContext
    }

    companion object{
        lateinit var appContext: Context
    }
}

