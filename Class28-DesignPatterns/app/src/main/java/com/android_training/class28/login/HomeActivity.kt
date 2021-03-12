package com.android_training.class28.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_training.class28.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private fun init() {
        var session = SingleSessionManager.getInstance()

        txt_welcome.text = "Welcome \n" + session.getCurrentUser()

        btn_logout.setOnClickListener {
            session.logout()
            navigateToLogin()
        }
        btn_delete.setOnClickListener {
            session.deleteCurrentUser()
            navigateToRegister()
        }
    }
    private fun navigateToLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun navigateToRegister(){
        startActivity(Intent(this, RegisterActivity::class.java))
        finish()
    }
}