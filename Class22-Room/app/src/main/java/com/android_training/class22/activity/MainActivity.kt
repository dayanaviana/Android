package com.android_training.class22.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android_training.class22.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_create.setOnClickListener(this)
        button_update.setOnClickListener(this)
        button_delete.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view){
            button_create -> startActivity(Intent(this, CreateActivity::class.java))
            button_delete -> startActivity(Intent(this, DeleteActivity::class.java))
            button_update -> startActivity(Intent(this, UpdateActivity::class.java))
        }
    }
}