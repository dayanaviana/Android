package com.android_training.class23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android_training.class23.models.LoginResponse
import com.android_training.class23.models.User
import com.android_training.class23.network.MyRetrofitApi
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_login
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
        btn_login.setOnClickListener {
            var email = edt_login_email.text.toString()
            var password = edt_login_password.text.toString()
            login(email,password)
        }
    }
    private fun login(email: String, password:String) {
        var myRetrofitApi = MyRetrofitApi()
        var user = User(email = email, password = password)
        myRetrofitApi.postLogin(user).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()}
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                var isSuccessful = response.isSuccessful
                if(!isSuccessful){
                    var errorBody = response.errorBody()?.charStream()?.readText()
//                    var errorResponse = response.errorBody() as LoginResponseError
//                    var errorMessage = errorResponse.message
                    txt_login_error.text = errorBody
                }else{
                    var user = response.body()?.user
                    var intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    intent.putExtra(User.DATA, user)
                    startActivity(intent)
                }
            }
        })
    }
}