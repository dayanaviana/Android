package com.android_training.class23.network

import com.android_training.class23.app.Config
import com.android_training.class23.models.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyRetrofitApi {

    @GET("category")
    fun getCategory(): Call<CategoryResponse>

    @GET("subcategory/{catId}")
    fun getSubCategory(@Path("catId") catId: Int): Call<SubcategoryResponse>

    @POST("auth/login")
    fun postLogin(@Body user: User): Call<LoginResponse>

    @POST("/api/auth/register")
    fun postRegister(@Body user: User): Call<RegisterResponse>

    @PUT("/api/users/{id}")
    fun editUser(@Path("id") id: String,
                 @Body user: User): Call<RegisterResponse>

    @DELETE("/api/users/{id}")
    fun deleteUser(@Path("id") id: String) : Call<RegisterResponse>

    companion object{
        operator fun invoke(): MyRetrofitApi {
            return Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyRetrofitApi::class.java)
        }
    }
}