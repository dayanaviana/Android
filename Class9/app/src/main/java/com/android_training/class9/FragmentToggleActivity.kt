package com.android_training.class9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_training.R
import kotlinx.android.synthetic.main.activity_fragment_toggle.*

class FragmentToggleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_toggle)

        init()
    }

    private fun init() {
        var flag: Boolean = true
        button_change_fragment.setOnClickListener {
            //1st: Fragment Manager
            var fragmentManager = supportFragmentManager
            //2nd: Fragment Transaction
            var fragmentTransaction = fragmentManager.beginTransaction()

            //If any, remove element before adding
//            if(fragmentManager.findFragmentByTag("frag_container")!= null){
//                fragmentTransaction.remove(fragmentManager.findFragmentByTag("frag_container")!!).commit()
//            }

            if (flag == true) {
                flag = false;
                //3rd: Add
                var demoFragment = DemoFragment()
                //4th: Commit
                fragmentTransaction.replace(R.id.frag_container, demoFragment).commit()
            } else {
                flag = true;
                //3rd: Add
                var demo2Fragment = FragmentOne()
                //4th: Commit
                fragmentTransaction.replace(R.id.frag_container, demo2Fragment).commit()
            }
        }
    }
}