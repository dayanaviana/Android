package com.android_training.class23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android_training.class23.models.*
import com.android_training.class23.network.MyRetrofitApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        btn_get_categories.setOnClickListener {
            getData()
        }
        btn_clear.setOnClickListener { text_view_result.text = "" }

        btn_get_subcategories.setOnClickListener { getSubCategory() }

        btn_login.setOnClickListener { login() }
    }

    private fun login() {
        var myRetrofitApi = MyRetrofitApi()
        var user = User(email = "dayana@gmail.com", password = "password1")
        myRetrofitApi.postLogin(user).enqueue(object : Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()}
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                var isSuccessful = response.isSuccessful
                if(!isSuccessful){
                    var errorBody = response.errorBody()?.charStream()?.readText()
//                    var errorResponse = response.errorBody() as LoginResponseError
//                    var errorMessage = errorResponse.message
                    text_view_result.text = errorBody
                }else{
                    var token = response.body()?.token
                    Toast.makeText(applicationContext,token, Toast.LENGTH_SHORT).show()

                    var user = response.body()?.user
                    text_view_result.text = user.toString()
                }
            }
        })
    }

    private fun getSubCategory() {
        var myRetrofitApi = MyRetrofitApi()
        myRetrofitApi.getSubCategory(1).enqueue(object: Callback<SubcategoryResponse>{
            override fun onFailure(call: Call<SubcategoryResponse>, t: Throwable) {
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()}
            override fun onResponse(
                call: Call<SubcategoryResponse>,
                response: Response<SubcategoryResponse>
            ) {
                var count = response.body()?.count.toString()
                Toast.makeText(applicationContext,count, Toast.LENGTH_SHORT).show()

                var data = response.body()?.data
                text_view_result.text = Arrays.toString(data)
            }
        })
    }

    private fun getData() {
        var myRetrofitApi = MyRetrofitApi()
        myRetrofitApi.getCategory().enqueue(object : Callback<CategoryResponse>{
            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_SHORT).show()}
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                var count = response.body()?.count.toString()
                Toast.makeText(applicationContext,count, Toast.LENGTH_SHORT).show()

                var data = response.body()?.data
                text_view_result.text = Arrays.toString(data)
            }

        })
    }
}