package com.android_training.class23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android_training.class23.models.RegisterResponse
import com.android_training.class23.models.User
import com.android_training.class23.network.MyRetrofitApi
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private fun init() {
        var user = intent.getSerializableExtra(User.DATA) as User
        txt_id.text = user._id
        edt_email.setText(user.email)
        edt_mobile.setText(user.mobile)
        edt_name.setText(user.firstName)
//        edt_password.setText(user.password)
        edt_password.setText("password")

        btn_edit.setOnClickListener{editUser(user)}
    }

    private fun editUser(user: User) {
        var myRetrofitApi = MyRetrofitApi()
        myRetrofitApi.editUser(user._id!!, user).enqueue(object : Callback<RegisterResponse> {
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()}
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                var message = response.body()?.message
                Toast.makeText(applicationContext,message, Toast.LENGTH_LONG).show()
                var isSuccessful = response.isSuccessful
                if(!isSuccessful){
                    var errorBody = response.errorBody()?.charStream()?.readText()
                }else{

                }
            }
        })
    }


}