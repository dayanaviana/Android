package com.android_training.coroutines.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android_training.coroutines.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class Example1Activity : AppCompatActivity() {

    var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example1)
        init()
    }

    private fun init() {
        val startTime = System.currentTimeMillis()

        val parentJob = CoroutineScope(Dispatchers.IO).launch {

            val job1 = launch {
                val time1 = measureTimeMillis {
                    Log.d("myApp", "JOB1: Thread=${Thread.currentThread().name}")
                    apiRequest1()
                    Log.d("myApp", "JOB1: text= $text")
                }
                Log.d("myApp", "JOB1: Completed in $time1 ms.")
            }

            //Makes 1st job finish before going to second job
//            job1.join()

            val job2 = launch {
                val time2 = measureTimeMillis {
                    Log.d("myApp", "JOB2: Thread=${Thread.currentThread().name}")
                    apiRequest2()
                    Log.d("myApp", "JOB2: text= $text")
                }
                Log.d("myApp", "JOB2: Completed in $time2 ms.")
            }
        }
        parentJob.invokeOnCompletion {
            Log.d("myApp", "Total elapsed time= ${System.currentTimeMillis() - startTime}")
        }
    }
    suspend fun apiRequest1() {
        var result = doSomething()
        setNewText(result)
    }
    suspend fun apiRequest2(){
        var result2 = doSomething2()
        setNewText(result2)
    }

    private fun setNewText(input: String){
        text = "$input"
    }

    suspend fun doSomething2(): String{
        logThread("doSomething2()")
        delay(2000)
        return "Bye"
    }
    suspend fun doSomething():String{
        logThread("doSomething()")
        delay(5000)
        return "Hello"
    }
    private fun logThread(methodName: String){
        Log.d("myApp", "$methodName: Thread= ${Thread.currentThread().name}")
    }
}