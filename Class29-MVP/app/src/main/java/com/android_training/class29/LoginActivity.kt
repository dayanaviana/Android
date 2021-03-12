package com.android_training.class29

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android_training.class29.model.LoginPresenterImpl
import com.android_training.class29.presentor.LoginPresenter
import com.android_training.class29.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenterImpl(this)
        init()
    }

    private fun init() {
        btn_login.setOnClickListener {
            var email = edt_login_email.text.toString()
            var password = edt_login_password.text.toString()
            loginPresenter.login(email, password)
        }
    }

    override fun setEmailError() {
        TODO("Not yet implemented")
    }

    override fun setPasswordError() {
        TODO("Not yet implemented")
    }

    override fun redirect() {
        TODO("Not yet implemented")
    }

    override fun setMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}