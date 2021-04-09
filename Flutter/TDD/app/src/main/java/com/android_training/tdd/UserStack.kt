package com.android_training.tdd

class UserStack {
    var array = ArrayList<Int>()

    fun push(element: Int) {
        array.add(element)
    }

    fun pop(): Int? {
        if(array.isNotEmpty()){
            return array.removeAt(array.lastIndex)
        }else{
            return null
        }
    }

    fun checkNull(): Boolean {
        return array.isEmpty()
    }

    fun checkNotNull(): Boolean {
        return array.isNotEmpty()
    }

    fun peep(position: Int): Int {
        return array.removeAt(position)
    }
}