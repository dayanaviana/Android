package com.android_training.coroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    fun getUsersCount(): LiveData<Int>{
        val liveData = MutableLiveData<Int>()
        viewModelScope.launch {
            val data = AuthApi.getApi().getAllUsers()
            liveData.value = data.count
        }
        return liveData
    }
    fun registerUser(): LiveData<String>{
        val liveData = MutableLiveData<String>()
        viewModelScope.launch {
            var user = User(email = "dayana8@gmail.com", password = "password", name= "Dayana8", type = "landlord")
            try {
                val data = AuthApi.getApi().postRegisterUser(user)
                liveData.value = data.message
            }catch (e: Exception){
                var x = e.localizedMessage
                liveData.value = "Network error"
            }
        }
        return liveData
    }
}