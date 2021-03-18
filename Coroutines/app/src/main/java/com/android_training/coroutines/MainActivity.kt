package com.android_training.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scope = CoroutineScope(Dispatchers.IO).launch {
            apiRequest()
        }
        Log.d("myApp", "onCreate(): After coroutine scope launch")
//        scope.cancel()

        my_btn.setOnClickListener {
            Log.d("myApp", "Clicked")
            CoroutineScope(Dispatchers.Main).launch {
                setTextOnMainThread("New Text")
            }
        }
    }

    suspend fun apiRequest(){
        var result = doSomething()
        Log.d("myApp", "apiRequest()")
        setTextOnMainThread(result)

        //it waits for first result before moving foward

        var result2 = doSomething2()
        setTextOnMainThread(result2)
    }
    suspend fun doSomething2(): String{
        logThread("doSomething2()")
        delay(5000)
        return "Bye"
    }
    suspend fun doSomething():String{
        logThread("doSomething()")
        delay(5000)
        return "Hello"
    }
    private fun logThread(methodName: String){
        Log.d("myApp", "$methodName: Thread=${Thread.currentThread().name}")
    }

    private fun setNewText(input: String){
        val newText = txt_hello.text.toString() + "\n$input"
        txt_hello.text = newText
    }
    suspend fun setTextOnMainThread(input: String){
        withContext(Main){
            setNewText(input)
        }
    }

}