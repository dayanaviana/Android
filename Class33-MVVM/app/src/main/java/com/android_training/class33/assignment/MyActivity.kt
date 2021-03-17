package com.android_training.class33.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android_training.class33.R
import kotlinx.android.synthetic.main.activity_my.*

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)
        init()
    }

    private fun init() {
        var viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.getNumber()
        viewModel.ramdomNumber.observe(this, Observer{
            text_view.text = it.toString()
            Log.d("myApp","Random number received: $it")
        })
    }

    override fun onPause() {
        super.onPause()
        Log.d("myApp", "onPause: User locks screen")
    }
    override fun onStop(){
        super.onStop()
        Log.d("myApp", "onStop: User locks screen")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("myApp", "onRestart: User unlock the screen")
    }

    override fun onStart() {
        super.onStart()
        Log.d("myApp", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("myApp", "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("myApp", "onDestroy")
    }
}