package com.android_training.class5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_button_click.*
import kotlinx.android.synthetic.main.activity_button_click.view.*

class ButtonClickActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_click)

        init()
    }

    private fun init() {
        //1st way of handling
        button_1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("button", "Button Clicked 1")
            }
        })

        //2nd way of handling: Using lambda
        button_2.setOnClickListener {
            Log.d("button", "Button clicked 2")
        }

        // 3rd way of handling
        button_3.setOnClickListener(this)
        button_4.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button_3 -> Log.d("button", "Button clicked 3")
            R.id.button_4 -> Log.d("button", "Button clicked 4")
        }
    }

    // 4th way
    fun onClickButton5(view: View) {
        var text = view.button_5.text
        Log.d("button", "Clicked: $text")
    }
}


