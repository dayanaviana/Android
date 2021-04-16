package com.android_training.mvvm_retrofit

class Todos : ArrayList<TodoItem>()

data class TodoItem(
    var completed: Boolean,
    var id: Int,
    var title: String,
    var userId: Int
)