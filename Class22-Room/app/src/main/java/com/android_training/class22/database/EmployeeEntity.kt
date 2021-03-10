package com.android_training.class22.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "employee")
data class EmployeeEntity (

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "first_name")
    var name: String? = "",
    var email: String? = ""
): Serializable {
    companion object{
        const val DATA = "EMPLOYEE"
    }
}