package com.android_training.coroutines.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android_training.coroutines.R
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class Example2Activity : AppCompatActivity() {

    var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example1)
        init()
    }

    private fun init() {

        val parentJob = CoroutineScope(Dispatchers.IO).launch {

            val executionTime = measureTimeMillis {
                val result1: Deferred<String> = async {
                    Log.d("myApp", "JOB1: Thread= ${Thread.currentThread().name}")
                    apiRequest1()
                }
                val result2: Deferred<String> = async {
                    Log.d("myApp", "JOB2: Thread= ${Thread.currentThread().name}")
                    apiRequest2()
                }

                setTextOnMainThread("${result2.await()}")
                setTextOnMainThread("${result1.await()}")
            }
            Log.d("myApp", "Total elapsed time= ${executionTime}")
        }
    }
    suspend fun apiRequest1() : String{
        delay(5000)
        return "Hello"
    }
    suspend fun apiRequest2(): String{
        delay(2000)
        return "Bye"
    }

    suspend fun setTextOnMainThread(input: String){
        withContext(Dispatchers.Main){
            setNewText(input)
        }
    }
    private fun setNewText(input: String){
        text = "$input"
        Log.d("myApp", "setNewText: text= $text")
    }
}