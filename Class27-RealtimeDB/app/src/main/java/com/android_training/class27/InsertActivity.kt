package com.android_training.class27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_insert.*

class InsertActivity : AppCompatActivity() {
    lateinit var firebaseDB: FirebaseDatabase
    lateinit var dbReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        firebaseDB = FirebaseDatabase.getInstance()
        dbReference = firebaseDB.getReference(Employee.KEY_EMPLOYEE)

        init()
    }

    private fun init() {
        btn_add.setOnClickListener {
            var name = edt_name.text.toString()
            var email = edt_email.text.toString()
            var employee = Employee(name, email)

            var empId = dbReference.push().key
            dbReference.child(empId!!).setValue(employee)
//            dbReference.child(email).setValue(employee)
            txt_token.text = "$name inserted"
//            Toast.makeText(applicationContext, "record inserted", Toast.LENGTH_LONG).show()
        }
    }
}