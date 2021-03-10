package com.android_training.news_reader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_training.class23.R
import com.android_training.news_reader.adapter.AdapterNews
import com.android_training.news_reader.model.Article
import com.android_training.news_reader.model.NewsResponse
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_recycler_view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var adapterNews: AdapterNews
    var mList: ArrayList<Article>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        init()
    }

    private fun init() {
        adapterNews = AdapterNews(this)

        getData()

        recycler_view.adapter = adapterNews
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(
            DividerItemDecoration(recycler_view.getContext(), DividerItemDecoration.VERTICAL)
        )
    }

    private fun getData() {
        var myRetrofit = NewsRetrofitApi()

        var country="us"
        var category="business"
        var apiKey="e2dae1085a724295b214b22dec344674"
        myRetrofit.getNews(country, category, apiKey).enqueue(
            object : Callback<NewsResponse> {
                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                    Log.d("myApp", t.message!!)
                }
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    var articles = response.body()?.articles
                    progress_bar.visibility = View.GONE
                    if (articles != null) {
                        adapterNews.setData(articles)
                    }
                }
            }
        )
    }
}