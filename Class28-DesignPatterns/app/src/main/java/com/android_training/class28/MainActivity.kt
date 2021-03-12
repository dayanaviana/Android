package com.android_training.class28

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        var singletonJava = SingletonJava.getInstance()
        var count1 = singletonJava.count
//        Log.d("myApp", count1.toString())

        var singletonJava2 = SingletonJava.getInstance()
        var count2 = singletonJava2.count
//        Log.d("myApp", count2.toString())

//        --------------------------------------------------------------

        var singleton = Singleton.getInstance()
        var count = singleton.count
        Log.d("myApp", count.toString())

        var singleton1 = Singleton.getInstance()
        var countx = singleton.count
        Log.d("myApp", countx.toString())
    }
}