package com.android_training.mvvm_retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*

interface MyRetrofitApi {

    @GET ("todos/")
    suspend fun getTodos() : Todos

    //todos?userId=1
    @GET("todos/")
    suspend fun getTodoByUserId(@Query("userId") userId: Int) : Todos

    //todos/1
    @GET("todos/{id}")
    suspend fun getTodoById(@Path("id") id: Int) : TodoItem

    @POST("todos/")
    suspend fun postTodo(@Body item:TodoItem): TodoItem

    @PUT("todos/{id}")
    suspend fun putTodo(@Path("id") id: Int,
                @Body item:TodoItem): TodoItem

    @DELETE("todos/{id}")
    suspend fun deleteTodo(@Path("id") id: Int)

    companion object{
        operator fun invoke(): MyRetrofitApi{
            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyRetrofitApi::class.java)
        }
    }
}