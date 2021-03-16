package com.android_training.class32

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.RandomNumberGenerator

class MyViewModelWithLiveData : ViewModel(){

    private var randomNumber: MutableLiveData<String>? = null

    fun getNumber(){
        randomNumber?.value = RandomNumberGenerator().getNumber()
    }

    fun getLiveData(): MutableLiveData<String>? {
        if (randomNumber == null) {
            randomNumber = MutableLiveData()
        }
        return randomNumber
    }
}