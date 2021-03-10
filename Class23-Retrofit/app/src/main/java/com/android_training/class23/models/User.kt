package com.android_training.class23.models

import java.io.Serializable

data class User(
//    val __v: Int? = 0,
    val email: String? = "",
    val password: String? = "",
    val firstName: String? = "",
    val mobile: String? = "",
    val _id: String? = "",
    val createdAt: String? = ""
): Serializable {
    companion object{
        const val DATA = "USER"
    }
}