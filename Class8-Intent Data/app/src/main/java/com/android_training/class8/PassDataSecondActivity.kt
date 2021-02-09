package com.android_training.class8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_passdata_second.*

class PassDataSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passdata_second)

        init()
    }

    private fun init() {
        //First Way
        var firstname = intent.getStringExtra("FIRSTNAME")
        var lastname = intent.getStringExtra("LASTNAME")
        txt_view1.text = "$firstname $lastname"

        //Second Way
        var bundle = intent.getBundleExtra("DATA")
        var name = bundle?.getString("NAME")
        var email = bundle?.getString("EMAIL")
        var phone = bundle?.getString("PHONE")

        txt_view2.text = "$name \n $email \n $phone"
    }


}