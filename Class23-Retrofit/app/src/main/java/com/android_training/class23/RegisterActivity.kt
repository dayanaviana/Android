package com.android_training.class23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android_training.class23.models.RegisterResponse
import com.android_training.class23.models.User
import com.android_training.class23.network.MyRetrofitApi
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
    }

    private fun init() {
        btn_register.setOnClickListener {
            var name = edt_reg_name.text.toString()
            var email = edt_reg_email.text.toString()
            var mobile = edt_reg_mobile.text.toString()
            var password = edt_reg_password.text.toString()

            register(name,email,mobile,password)
        }
    }
    private fun register(name:String, email: String, mobile:String, password:String) {
        var myRetrofitApi = MyRetrofitApi()
        var user = User(email,password,name,mobile,null,null)
        myRetrofitApi.postRegister(user).enqueue(object : Callback<RegisterResponse> {
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()}
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                var message = response.body()?.message
                Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
                var isSuccessful = response.isSuccessful
                if(!isSuccessful){
                    var errorBody = response.errorBody()?.charStream()?.readText()
                    txt_register_error.text = errorBody
                }else{
                    var intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }
}