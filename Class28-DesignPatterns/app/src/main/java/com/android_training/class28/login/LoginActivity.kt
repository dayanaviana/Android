package com.android_training.class28.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android_training.class28.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
        var session = SingleSessionManager.getInstance()

        if(session.isLoggedIn()) {
            navigateToHome()
        }

        btn_login.setOnClickListener {
            var email = edt_login_email.text.toString()
            var password = edt_login_password.text.toString()
            if(session.verifyLogin(email, password)){
                navigateToHome()
            }else{
                Toast.makeText(applicationContext, "Login error", Toast.LENGTH_LONG).show()
            }
        }

        txt_new_user.setOnClickListener { navigateToRegister()}
    }
    private fun navigateToHome(){
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
    private fun navigateToRegister(){
        startActivity(Intent(this, RegisterActivity::class.java))
        finish()
    }
}