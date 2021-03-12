package com.android_training.class28

class Singleton {
    var count = 0
    private set

    private constructor(){
        count += 1
    }

    companion object{

        private var instance: Singleton? = null

        fun getInstance(): Singleton{
            if(instance==null){
                instance = Singleton()
            }
            return instance!!
        }
    }
}