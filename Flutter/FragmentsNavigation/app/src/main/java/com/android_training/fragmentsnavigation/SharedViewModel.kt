package com.android_training.fragmentsnavigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private var _country = MutableLiveData<String>("Brazil")

    var country: LiveData<String> = _country

    fun saveCountry(newCountry: String){
        _country.value = newCountry
    }
}