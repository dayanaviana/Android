package com.android_training.class22.database

import androidx.room.*

@Database(entities = [EmployeeEntity::class], version = 2)
abstract class MyDatabase : RoomDatabase(){
    abstract fun getDao(): DaoEmployee
}