package com.android_training.class22.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.android_training.class22.database.EmployeeEntity
import com.android_training.class22.R
import com.android_training.class22.database.MyDatabase
import kotlinx.android.synthetic.main.activity_delete.*

class DeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        init()
    }

    private fun init() {
        btn_delete.setOnClickListener {
            var id = edt_id.text.toString().toInt()
            var emp = EmployeeEntity(
                id,
                null,
                null
            )

            var mydb = Room.databaseBuilder(
                applicationContext, MyDatabase::class.java, "mydb"
            ).allowMainThreadQueries().build()

            mydb.getDao().deleteEmployee(emp)

            Toast.makeText(applicationContext, "Record Deleted", Toast.LENGTH_SHORT).show()
        }
    }
}