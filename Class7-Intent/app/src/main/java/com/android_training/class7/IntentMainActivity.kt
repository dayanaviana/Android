package com.android_training.class7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_intent_main.*

class IntentMainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_main)
        Log.d("abc", "Main OnCreate")

        init()
    }

    private fun init() {
        button_class7.setOnClickListener(this)

//        button_next.setOnClickListener(object: View.OnClickListener{
//            override fun onClick(p0: View?) {
//                var intent = Intent(this@MainActivity, SecondActivity::class.java)
//                startActivity(intent)
//            }
//
//        })
    }

    override fun onClick(p0: View?) {
        var intent = Intent(this, IntentSecondActivity::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d("abc", "Main OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("abc", "Main OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("abc", "Main OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("abc", "Main OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("abc", "Main OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("abc", "Main OnDestroy")
    }


}