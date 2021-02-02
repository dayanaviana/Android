package com.android_training

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class lifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.d("activity_status", "OnCreate")
    }
    override fun onRestart() {
        super.onRestart()

        Log.d("activity_status", "OnRestart")
    }
    override fun onStart() {
        super.onStart()
        Log.d("activity_status", "OnStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("activity_status", "OnResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("activity_status", "OnPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("activity_status", "OnStop")
    }
    override fun onDestroy() {
        super.onDestroy()

        Log.d("activity_status", "OnDestroy")
    }
}