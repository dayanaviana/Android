package com.android_training.class6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        Log.d("activity_status", "IntentActivity: OnCreate")

        init()
    }
    private fun init(){
        button_next.setOnClickListener(this)
//        button_next.setOnClickListener(object: View.OnClickListener{
//            override fun onClick(v: View?) {
//                var intent = Intent(this@IntentActivity, LifecycleActivity::class.java)
//                startActivity(intent)
//            }
//        })
    }
    override fun onClick(p0: View?){
        var intent = Intent(this@IntentActivity, LifecycleActivity::class.java)
                startActivity(intent)
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("activity_status", "IntentActivity: OnRestart")
    }
    override fun onStart() {
        super.onStart()
        Log.d("activity_status", "IntentActivity: OnStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("activity_status", "IntentActivity: OnResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("activity_status", "IntentActivity: OnPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("activity_status", "IntentActivity: OnStop")
    }
    override fun onDestroy() {
        super.onDestroy()

        Log.d("activity_status", "IntentActivity: OnDestroy")
    }
}