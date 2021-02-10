package com.dayanaviana.therealproject.loginsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dayanaviana.therealproject.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }
    private fun init(){
        var name = intent.getStringExtra("NAME")
        txt_welcome.text = "Welcome $name"
    }
}