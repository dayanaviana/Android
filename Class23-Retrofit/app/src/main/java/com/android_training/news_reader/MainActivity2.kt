package com.android_training.news_reader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android_training.class23.R
import com.android_training.news_reader.model.NewsResponse
import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
    }

    private fun init() {
        getData()
    }

    private fun getData() {
        var myRetrofit = NewsRetrofitApi()

        var country="us"
        var category="business"
        var apiKey="e2dae1085a724295b214b22dec344674"
        myRetrofit.getNews(country, category, apiKey).enqueue(
            object :Callback<NewsResponse>{
                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                    Log.d("myApp", t.message!!)
                }
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    var body = response.body()
                    txt_data.text = body.toString()
                }
            }
        )
    }
}