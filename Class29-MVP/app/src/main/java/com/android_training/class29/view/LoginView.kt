package com.android_training.class29.view

interface LoginView {
    fun setEmailError()
    fun setPasswordError()
    fun redirect()
    fun setMessage(message: String)
}