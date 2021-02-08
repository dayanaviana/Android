package com.android_training.serviceproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {

            var myInent = Intent(this,MyMusicService::class.java)
            startService(myInent)

        }

        buttonStop.setOnClickListener {
            var myIntent = Intent(this, MyMusicService::class.java)
            stopService(myIntent)
        }
    }
}