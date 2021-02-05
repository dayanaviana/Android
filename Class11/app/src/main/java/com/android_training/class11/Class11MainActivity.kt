package com.android_training.class11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_training.class11.adapter.MyFragmentAdapter
import kotlinx.android.synthetic.main.activity_main_class11.*

class Class11MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class11)

        init()
    }
    private fun init(){
        var myFragmentAdapter = MyFragmentAdapter(supportFragmentManager)
        view_pager.adapter = myFragmentAdapter

        tab_layout.setupWithViewPager(view_pager)

        //Add icons to Tab Layout
//        tab_layout.getTabAt(0)!!.setIcon( R.drawable.ic_baseline_child_care_24)
//        tab_layout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_adb_24)
//        tab_layout.getTabAt(2)!!.setIcon(R.drawable.ic_android_black_24dp)

        //Handle icons setup on adapter
        myFragmentAdapter.setTitleIcons(tab_layout)
    }
}