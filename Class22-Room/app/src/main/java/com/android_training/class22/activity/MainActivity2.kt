package com.android_training.class22.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.android_training.class22.adapter.AdapterEmployee
import com.android_training.class22.database.EmployeeEntity
import com.android_training.class22.R
import com.android_training.class22.database.MyDatabase
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
    }

    private fun init() {
        loadList()

        btn_add_new.setOnClickListener {
            startActivity(Intent(this, CreateActivity::class.java))
        }
    }

    private fun loadList() {
        var mydb = Room.databaseBuilder(this, MyDatabase::class.java,"mydb")
            .allowMainThreadQueries().build()
        var mList = ArrayList<EmployeeEntity>()
        mList.addAll(mydb.getDao().readData())

        var adapterEmployee =
            AdapterEmployee(this)
        adapterEmployee.setData(mList)

        recycler_view.adapter = adapterEmployee
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(
            DividerItemDecoration(recycler_view.getContext(), DividerItemDecoration.VERTICAL)
        )
    }

    override fun onRestart() {
        super.onRestart()
        loadList()
    }
}