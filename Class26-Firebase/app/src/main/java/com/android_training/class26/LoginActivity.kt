package com.android_training.class26

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance();
        init()
    }

    private fun init() {
        btn_login.setOnClickListener {
            var email = edt_login_email.text.toString()
            var password = edt_login_password.text.toString()
            login(email,password)
        }

        txt_new_user.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        txt_forgot_password.setOnClickListener { forgotPassword() }
    }

    private fun forgotPassword() {
        var email = edt_login_email.text.toString()
        mAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    Toast.makeText(applicationContext, "Reset email sent", Toast.LENGTH_SHORT).show()
                }else{
                    var message = task.exception!!.message
                    Log.d("myApp", message!!)
                    Toast.makeText(applicationContext, "Failed to Send reset email", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this, object: OnCompleteListener<AuthResult>{
                override fun onComplete(task: Task<AuthResult>) {
                    if(task.isSuccessful){
//                        Toast.makeText(applicationContext, "Login Successfully", Toast.LENGTH_LONG).show()
                        navigateToHome()
                    }else{
                        var message = task.exception!!.message
                        Log.d("myApp", message!!)
                        Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_LONG).show()
                    }
                }
            })
    }

    private fun navigateToHome(){
        startActivity(Intent(this, HomeActivity::class.java))
    }
}