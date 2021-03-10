package com.android_training.class23.models

data class RegisterResponse(
    val user: User,
    val error: Boolean,
    val message: String
)