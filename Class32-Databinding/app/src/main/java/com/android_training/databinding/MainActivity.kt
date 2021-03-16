package com.android_training.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import com.android_training.databinding.databinding.ActivityMainBinding
import com.android_training.databinding.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mDataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        init()
    }

    private fun init() {
        var user = User(email = "watson@gmail.com", password = "password")
        mDataBinding.userEdit = user

        btn_bind.setOnClickListener {
            mDataBinding.userInfo = mDataBinding.userEdit
        }
    }
}