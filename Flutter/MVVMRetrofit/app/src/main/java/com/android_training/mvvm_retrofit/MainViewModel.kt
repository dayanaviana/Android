package com.android_training.mvvm_retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var liveData = MutableLiveData<Any>()

    fun getTodos(){
        Log.d("myApp", "ViewModel getTodos()")
        viewModelScope.launch {
            var api = MyRetrofitApi.invoke()
            liveData.postValue(api.getTodos())
        }
    }

    fun getTodoByUserID(id: Int){
        Log.d("myApp", "ViewModel getTodoByUserID()")
        viewModelScope.launch {
            var api = MyRetrofitApi.invoke()
            liveData.postValue(api.getTodoByUserId(id))
        }
    }

    fun getTodoById(id: Int){
        Log.d("myApp", "ViewModel getTodoById()")
        viewModelScope.launch {
            var api = MyRetrofitApi.invoke()
            liveData.postValue(api.getTodoById(id))
        }
    }
}