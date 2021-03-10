package com.dayanaviana.therealproject.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dayanaviana.therealproject.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
    }
    private fun init(){

        var intent = Intent(this@RegisterActivity, LoginActivity::class.java)

        btn_submit.setOnClickListener {
            var name = edt_name.text.toString()
            var email = edt_email.text.toString()
            var password = edt_password.text.toString()

            intent.putExtra("NAME", name)
            intent.putExtra("EMAIL",email)
            intent.putExtra("PASSWORD",password)

            navigateToLogin(intent)

        }
        txt_registered.setOnClickListener {
            navigateToLogin(intent)
        }
    }

    fun navigateToLogin(intent: Intent){
        startActivity(intent)
    }
}