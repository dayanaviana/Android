package com.example.android.tmo.test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.tmo.test.R

/**
 * 1. Create the UI components for Alpha, Beta, Gamma fragments
 * 2. Create on touch listeners (Bonus points for databinding)
 *      a. Integrate Navigation Component
 * 3. Make network call to Cat Facts API
 *      a. Update UI layer with the necessary information with observers (Bonus points for databinding)
 * 4. Make unit test for your view model
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}