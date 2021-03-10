package com.android_training.class27

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_read.*

class ReadActivity : AppCompatActivity() {

    lateinit var dbReference: DatabaseReference
    lateinit var adapterEmployee: AdapterEmployee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        dbReference = FirebaseDatabase.getInstance().getReference(Employee.KEY_EMPLOYEE)
        init()
    }

    private fun init() {
        adapterEmployee = AdapterEmployee(this)
        getData()

        recycler_view.adapter = adapterEmployee
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(
            DividerItemDecoration(recycler_view.getContext(), DividerItemDecoration.VERTICAL)
        )

        btn_insert.setOnClickListener {
            startActivity(Intent(this, InsertActivity::class.java))
        }

    }

    private fun getData() {

        dbReference.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                progress_bar.visibility = View.GONE
                Log.d("myApp", error.message)
                Toast.makeText(applicationContext, "Error getting data", Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                var mList: ArrayList<Employee> = ArrayList()
                for(data in snapshot.children){
                    var employee = data.getValue(Employee::class.java)
                    employee?.key = data.key
                    mList?.add(employee!!)
                }
                adapterEmployee.setData(mList)
                progress_bar.visibility = View.GONE
            }

        })

    }
}