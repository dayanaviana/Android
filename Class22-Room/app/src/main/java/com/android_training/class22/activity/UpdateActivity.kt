package com.android_training.class22.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.android_training.class22.database.EmployeeEntity
import com.android_training.class22.R
import com.android_training.class22.database.MyDatabase
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        init()
    }

    private fun init() {
        var employee = intent.getSerializableExtra(EmployeeEntity.DATA) as EmployeeEntity
        if(employee!=null){
            edt_id.setText(employee.id.toString())
            edt_id.isEnabled = false
            edt_name.setText(employee.name)
            edt_email.setText(employee.email)
        }

        btn_update.setOnClickListener {
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
                applicationContext, MyDatabase::class.java, "mydb"
            ).allowMainThreadQueries().build()

            mydb.getDao().updateEmployee(employee)

            Toast.makeText(applicationContext, "Record Updated", Toast.LENGTH_SHORT).show()
        }
    }
}