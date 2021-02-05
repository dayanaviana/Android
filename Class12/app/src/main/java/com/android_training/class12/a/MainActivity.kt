package com.android_training.class12.a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android_training.class12.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }
    private fun init(){
        generateData()

        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mList)
        list_view.adapter = arrayAdapter
        list_view.setOnItemClickListener(object: AdapterView.OnItemClickListener{

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity, arrayAdapter.getItem(position),Toast.LENGTH_LONG).show()
            }
        })


    }
    private fun generateData(){
        mList.add("Theodore Roosevelt")
        mList.add("William Howard Taft")
        mList.add("Woodrow Wilson")
        mList.add("Warren G. Harding[e]")
        mList.add("Calvin Coolidge")
        mList.add("Herbert Hoover")
        mList.add("Franklin D. Roosevelt[e]")
        mList.add("Harry S. Truman")
        mList.add("Dwight D. Eisenhower")
        mList.add("John F. Kennedy[s]")
        mList.add("Lyndon B. Johnson")
        mList.add("Richard Nixon[h]")
        mList.add("Gerald Ford")
        mList.add("Jimmy Carter")
        mList.add("Ronald Reagan")
        mList.add("George H. W. Bush")
        mList.add("Bill Clinton")
        mList.add("George W. Bush")
        mList.add("Barack Obama")
        mList.add("Donald Trump")
        mList.add("Joe Biden")
    }
}