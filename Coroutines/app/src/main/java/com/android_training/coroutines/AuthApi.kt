package com.android_training.coroutines

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @GET("users")
    suspend fun getAllUsers(): UsersResponse

    @POST("auth/register")
    suspend fun postRegisterUser(@Body user: User): RegisterResponse

    companion object{
//        operator fun invoke():AuthApi{
        fun getApi():AuthApi{
            return Retrofit.Builder()
                .baseUrl("https://apolis-property-management.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AuthApi::class.java)
        }
    }
}

data class UsersResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("data")
    val users: ArrayList<User>,
    @SerializedName("error")
    val error: Boolean
)

data class RegisterResponse(
    val data: User,
    val error: Boolean,
    val message: String
)

data class User(
//    val __v: Int? = 0,
    val email: String? = null,
    val password: String? = null,
    val _id: String? = null,
    val createdAt: String? = null,
    val type: String? = null,
    val name: String? = null,
    val landlordEmail: String? = null
)