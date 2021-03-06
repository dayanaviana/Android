package com.android_training.rxjava.models

import java.io.Serializable

data class LoginResponse(
    val token: String,
    val user: User
)
data class LoginResponseError(
    val error: Boolean,
    val message: String
)
