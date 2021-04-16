package com.android_training.mvvm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import java.util.*

class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    private fun init() {
        viewModel.getTodoById(1)
        viewModel.getTodoByUserID(1)
        viewModel.getTodos()

        viewModel.liveData.observe(this, Observer {
            Log.d("myApp", "LiveData onChange")
            Log.d("myApp", "$it")
        })
    }
}