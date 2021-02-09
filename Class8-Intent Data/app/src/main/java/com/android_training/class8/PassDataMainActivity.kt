package com.android_training.class8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_passdata_main.*

class PassDataMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passdata_main)

        init()
    }

    private fun init() {
        btn1_class8.setOnClickListener {
            var first_name = edt_first_name.text.toString()
            var last_name = edt_last_name.text.toString()
            var intent = Intent(this@PassDataMainActivity, PassDataSecondActivity::class.java)
            intent.putExtra("FIRSTNAME", first_name)
            intent.putExtra("LASTNAME", last_name)
            startActivity(intent)
        }

        btn2_class8.setOnClickListener {
            var name = edit_text_name.text.toString()
            var email = edit_text_email.text.toString()
            var phone = edit_text_phone.text.toString()


            var intent = Intent(this, PassDataSecondActivity::class.java)

            // first way
//            intent.putExtra("NAME", name)
//            intent.putExtra("EMAIL", email)
//            intent.putExtra("PHONE", phone)

            // second way
            var bundle = Bundle()
            bundle.putString("NAME", name)
            bundle.putString("EMAIL", email)
            bundle.putString("PHONE", phone)
            intent.putExtra("DATA", bundle)


            startActivity(intent)
        }
    }
}