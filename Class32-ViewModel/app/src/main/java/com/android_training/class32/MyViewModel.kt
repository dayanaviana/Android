package com.android_training.class32

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myapplication.RandomNumberGenerator

class MyViewModel: ViewModel() {
    private var numGenerator = RandomNumberGenerator()

    fun getNumber(): String?{
        return numGenerator.getNumber()
    }
    override fun onCleared() {
        super.onCleared()
        Log.d("myApp", "MyViewModel: onCleared")
    }
}