package com.android_training.class7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class IntentSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_second)
        Log.d("abc", "Second OnCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("abc", "Second OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("abc", "Second OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("abc", "Second OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("abc", "Second OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("abc", "Second OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("abc", "Second OnDestroy")
    }
}