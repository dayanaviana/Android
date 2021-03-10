package com.android_training.class27

data class Employee (
    var name: String? = null,
    var email: String? = null
    ,var key: String? = null
){
    companion object{
        const val KEY_EMPLOYEE = "employee"
    }
}