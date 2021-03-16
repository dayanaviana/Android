package com.android_training.rxjava

import android.app.Application
import com.android_training.rxjava.di.AppModule
import com.android_training.rxjava.di.DaggerAppComponent

class MyApplication: Application() {
    var daggerComponent: DaggerAppComponent? = null
    override fun onCreate() {
        super.onCreate()

        daggerComponent = DaggerAppComponent.builder()
            .appModule(AppModule()).build() as DaggerAppComponent
    }
}