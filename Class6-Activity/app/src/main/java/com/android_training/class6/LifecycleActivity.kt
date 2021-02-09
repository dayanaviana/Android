package com.android_training.class6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.d("activity_status", "LifecycleActivity: OnCreate")
    }
    override fun onRestart() {
        super.onRestart()

        Log.d("activity_status", "LifecycleActivity: OnRestart")
    }
    override fun onStart() {
        super.onStart()
        Log.d("activity_status", "LifecycleActivity: OnStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("activity_status", "LifecycleActivity: OnResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("activity_status", "LifecycleActivity: OnPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("activity_status", "LifecycleActivity: OnStop")
    }
    override fun onDestroy() {
        super.onDestroy()

        Log.d("activity_status", "LifecycleActivity: OnDestroy")
    }
}