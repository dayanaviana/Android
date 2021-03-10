package com.android_training.news_reader

import com.android_training.news_reader.model.NewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//https://newsapi.org/
interface NewsRetrofitApi {
    @GET("top-headlines")
//    @GET("top-headlines?country=us&category=business&apiKey=e2dae1085a724295b214b22dec344674")
    fun getNews(@Query("country")country:String,
                @Query("category")category:String,
                @Query("apiKey")apiKey:String
                ): Call<NewsResponse>

    companion object{
        operator fun invoke(): NewsRetrofitApi{
            //Top business headlines in the US right now
            //http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=a1c63f6fa6a645088799c895f54f5ed6
            val BASE_URL = "https://newsapi.org/v2/"

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsRetrofitApi::class.java)
        }
    }
}