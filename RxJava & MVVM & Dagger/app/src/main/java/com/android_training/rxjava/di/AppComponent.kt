package com.android_training.rxjava.di

import com.android_training.rxjava.activities.ProductActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(activity: ProductActivity)
}