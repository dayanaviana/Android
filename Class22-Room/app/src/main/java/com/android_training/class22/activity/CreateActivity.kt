package com.android_training.class22.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.android_training.class22.database.EmployeeEntity
import com.android_training.class22.R
import com.android_training.class22.database.MyDatabase
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        init()
    }

    private fun init() {
        btn_create.setOnClickListener {
            var id = edt_id.text.toString().toInt()
            var name = edt_name.text.toString()
            var email = edt_email.text.toString()
            var employee =
                EmployeeEntity(
                    id,
                    name,
                    email
                )

            var mydb = Room.databaseBuilder(
                applicationContext,
                MyDatabase::class.java,
                "mydb"
            ).allowMainThreadQueries().build()

            mydb.getDao().addEmployee(employee)

            Toast.makeText(applicationContext, "Record Inserted", Toast.LENGTH_SHORT).show()
        }
    }
}