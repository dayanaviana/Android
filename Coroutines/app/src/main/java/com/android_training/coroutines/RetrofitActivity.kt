package com.android_training.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class RetrofitActivity : AppCompatActivity() {
    val viewModel by viewModels<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        init()
    }

    private fun init() {

        viewModel.registerUser().observe(this, Observer{
            var msg = it
            Log.d("myApp", "Message = $msg")
        })

        viewModel.getUsersCount().observe(this, Observer {
            Log.d("myApp","Total users = $it")
        })
    }
}