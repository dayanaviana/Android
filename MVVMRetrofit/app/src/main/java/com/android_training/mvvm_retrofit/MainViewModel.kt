package com.android_training.mvvm_retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var liveData = MutableLiveData<Any>()
    var api = MyRetrofitApi.invoke()

    fun getTodos(){
        viewModelScope.launch {
            liveData.postValue(api.getTodos())
        }
    }

    fun getTodoByUserID(id: Int){
        viewModelScope.launch {
            liveData.postValue(api.getTodoByUserId(id))
        }
    }

    fun getTodoById(id: Int){
        viewModelScope.launch {
            liveData.postValue(api.getTodoById(id))
        }
    }
}