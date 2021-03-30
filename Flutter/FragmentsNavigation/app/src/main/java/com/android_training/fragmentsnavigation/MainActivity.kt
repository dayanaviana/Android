package com.android_training.fragmentsnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.frame_view, FragmentA())
//            .commit()
    }
}