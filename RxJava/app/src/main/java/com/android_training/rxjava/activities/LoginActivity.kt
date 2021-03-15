package com.android_training.rxjava.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android_training.class23.network.LoginApi
import com.android_training.rxjava.R
import com.android_training.rxjava.models.LoginResponse
import com.android_training.rxjava.models.User
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
        login("dayana@gmail.com","password")

        btn_login.setOnClickListener {
            var email = edt_login_email.text.toString()
            var password = edt_login_password.text.toString()
            login(email,password)
        }
    }
    private fun login(email: String, password:String) {
        var user = User(email = email, password = password)

        var loginApi = LoginApi()
        loginApi.postLogin(user).subscribeOn(Schedulers.io())
            .observeOn((AndroidSchedulers.mainThread()))
            .subscribeWith(object: SingleObserver<LoginResponse> {
                override fun onSuccess(t: LoginResponse) {
                    //Data Received
                    Log.d("myApp",t.token)
                }

                override fun onSubscribe(d: Disposable) {
                    Log.d("myApp","onSubscribe")
                }

                override fun onError(e: Throwable) {
                    Log.d("myApp","Error")
                }

            })
    }
}