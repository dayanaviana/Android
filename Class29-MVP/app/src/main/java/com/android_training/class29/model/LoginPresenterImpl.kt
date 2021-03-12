package com.android_training.class29.model

import com.android_training.class29.presentor.LoginPresenter
import com.android_training.class29.view.LoginView

class LoginPresenterImpl(var loginView: LoginView): LoginPresenter {
    override fun login(email: String, password: String) {
        if(email.equals("admin") && password.equals("123")){
            loginView.setMessage("LoginSuccess")
        }else{
            loginView.setMessage("Login Failed")
        }
    }
}