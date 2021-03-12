package com.android_training.class28.login

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.android_training.class28.Singleton

class SingleSessionManager {
    private val FILE_NAME = "my_login_file"
    private val KEY_CURRENT_EMAIL = "current_email"
    private val KEY_CURRENT_PASSWORD = "current_password"
    private val KEY_IS_LOGGED_IN = "isLoggedIn"

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private constructor(){
        var mContext = MyApplication.appContext
        sharedPreferences = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun register(email:String, password: String){
        editor.putString(email, password)
        editor.commit()
        Log.d("myApp", "Registered successfully")
    }

    fun verifyLogin(email: String, password: String): Boolean {
        var savedPassword = sharedPreferences.getString(email, "")
        if( savedPassword.equals(password)){
            editor.putString(KEY_CURRENT_EMAIL, email)
            editor.putString(KEY_CURRENT_PASSWORD, password)
            editor.commit()
            editor.putBoolean(KEY_IS_LOGGED_IN, true)
            return true
        }
        return false
    }

    fun getCurrentUser(): String?{
        return sharedPreferences.getString(KEY_CURRENT_EMAIL, null)
    }

    fun isLoggedIn(): Boolean{
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun logout(){
        editor.remove(KEY_IS_LOGGED_IN)
        editor.remove(KEY_CURRENT_EMAIL)
        editor.remove(KEY_CURRENT_PASSWORD)
        editor.commit()
    }

    fun deleteCurrentUser(){
        var email = getCurrentUser()
        editor.remove(email)
        editor.remove(KEY_IS_LOGGED_IN)
        editor.remove(KEY_CURRENT_EMAIL)
        editor.remove(KEY_CURRENT_PASSWORD)
        editor.commit()
    }

    fun clear(){
        editor.clear()
        editor.commit()
    }

    companion object{

        private var instance: SingleSessionManager? = null

        fun getInstance(): SingleSessionManager {
            if(instance==null){
                instance = SingleSessionManager()
            }
            return instance!!
        }
    }
}