package com.android_training.class33.assignment

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MyViewModel: ViewModel() {
    var ramdomNumber = MutableLiveData<Int>()

    fun getNumber(){

        //wait 10s
        Handler().postDelayed({
            ramdomNumber.value = Random.nextInt(0,100)
        },10000)

    }
}