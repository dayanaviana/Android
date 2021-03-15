package com.android_training.class23.network

import com.android_training.class23.app.Config
import com.android_training.rxjava.models.LoginResponse
import com.android_training.rxjava.models.User
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface LoginApi {

    @POST("auth/login")
    fun postLogin(@Body user: User): Single<LoginResponse>

    companion object{
        operator fun invoke(): LoginApi {
            return Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(LoginApi::class.java)
        }
    }
}