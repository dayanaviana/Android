package com.android_training.tdd

class UserQueue {
    private val mData = mutableListOf<Int>()
    val size: Int
        get()=mData.size

    val isEmpty:Boolean
        get() = mData.isEmpty()

    fun add(item:Int){
        mData.add(item)
    }

    @ExperimentalStdlibApi
    fun remove():Int?{
        return mData.removeFirstOrNull()
    }

    fun peek():Int?{
        return mData.firstOrNull()
    }
    fun peep(position:Int):Int?{
        return if((position<0) || (position>=mData.size))
            null
        else
            mData[position]
    }

}