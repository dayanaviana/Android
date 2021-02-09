package com.android_training.class9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_training.R

class FragmentNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_navigation)

        init()
    }

    private fun init() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, FragmentOne())
            .addToBackStack("")
            .commit()

    }
}