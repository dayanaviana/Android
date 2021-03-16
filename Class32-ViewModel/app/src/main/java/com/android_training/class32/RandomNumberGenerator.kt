package com.example.myapplication

import android.util.Log
import java.util.*

class RandomNumberGenerator {
    private var randomNumber: String? = null

    private fun createNumber(){
        var random = Random()
        var number = random.nextInt(10-1)+ 1
        randomNumber = "$number"
    }

    fun getNumber(): String?{
        if(randomNumber==null)
            createNumber()
        Log.d("abc", randomNumber.toString())
        return randomNumber
    }
}