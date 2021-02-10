package com.dayanaviana.therealproject.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dayanaviana.therealproject.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var email_intent = ""
    var password_intent = ""
    var name_intent = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }
    private fun init(){
        email_intent = intent.getStringExtra("EMAIL").toString()
        password_intent = intent.getStringExtra("PASSWORD").toString()
        name_intent = intent.getStringExtra("NAME").toString()

        btn_login.setOnClickListener {
            var name = "Admin"
            var email = edt_email.text.toString()
            var password = edt_password.text.toString()
            if (email == "admin" && password == "123") {
                txt_error.text = ""
                var intent = Intent(this@LoginActivity, HomeActivity::class.java)
                intent.putExtra("NAME", name)
                startActivity(intent)
            }else if(email == email_intent && password == password_intent){
                name = name_intent
                txt_error.text = ""
                var intent = Intent(this@LoginActivity, HomeActivity::class.java)
                intent.putExtra("NAME", name)
                startActivity(intent)

            }
            else{
                txt_error.text = "Invalid Username or Password"
            }
        }

        txt_new_user.setOnClickListener {
            var intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}