package com.android_training.fragmentsnavigation.model

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable

fun main(){
    print("Hello")
    val actor = Actor()
    actor.name = "My Name"
    actor.age = 27

    val intent = Intent()
    intent.putExtra("actor", actor)

    val array = arrayListOf(actor)
    intent.putParcelableArrayListExtra("actor",array)

}

class Actor() : Parcelable {
    var name: String = ""
    var age: Int = 0


    constructor(parcel: Parcel) : this() {
        name = parcel.readString().toString()
        age = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Actor> {
        override fun createFromParcel(parcel: Parcel): Actor {
            return Actor(parcel)
        }

        override fun newArray(size: Int): Array<Actor?> {
            return arrayOfNulls(size)
        }
    }
}