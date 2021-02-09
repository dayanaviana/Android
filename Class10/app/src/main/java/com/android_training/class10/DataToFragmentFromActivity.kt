package com.android_training.class10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class DataToFragmentFromActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }
    private fun init(){
        btn_sendToFrag.setOnClickListener {
            var name = edt_name.text.toString()
            var id:Int = edt_id.text.toString().toInt()
            var email = edt_email.text.toString()

            var blankFragment = BlankFragment.newInstance(id,name,email)

            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_layout, blankFragment)
                    .commit()
        }
    }
}