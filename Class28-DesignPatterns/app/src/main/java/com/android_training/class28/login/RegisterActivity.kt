package com.android_training.class28.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_training.class28.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
    }

    private fun init() {
        var session = SingleSessionManager.getInstance()

        btn_register.setOnClickListener {
            var email = edt_reg_email.text.toString()
            var password = edt_reg_password.text.toString()

            session.register(email, password)
            navigateToLogin()
        }

        txt_registered.setOnClickListener { navigateToLogin() }
    }
    private fun navigateToLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}