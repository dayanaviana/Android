package com.android_training.class9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_training.R
import kotlinx.android.synthetic.main.activity_fragment_main.*

class FragmentMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_main)

        init()
    }
    private fun init(){
        button_add_fragment.setOnClickListener {
            //1st: Fragment Manager
            var fragmentManager = supportFragmentManager
            //2nd: Fragment Transaction
            var fragmentTransaction = fragmentManager.beginTransaction()
            //3rd: Add
            var demoFragment = DemoFragment()
            //4th: Commit
            fragmentTransaction.add(R.id.fragment_container, demoFragment).commit()
        }
    }
}