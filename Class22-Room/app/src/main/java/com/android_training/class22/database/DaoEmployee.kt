package com.android_training.class22.database

import androidx.room.*

@Dao
interface DaoEmployee{
    @Insert
    fun addEmployee(e: EmployeeEntity)

    @Update
    fun updateEmployee(e: EmployeeEntity)

    @Delete
    fun deleteEmployee(e: EmployeeEntity)

    @Query("select * from employee")
    fun readData(): List<EmployeeEntity>

    @Query("select  * from employee where id = :id")
    fun getEmployeeById(id: Int): EmployeeEntity
}