package com.android_training.class32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.RandomNumberGenerator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Called when rotate the screen
        Log.d("myApp","MainActivity: onCreate")
        init()
    }

    private fun init() {
        //Directly accessing Class
        txt_number.text = RandomNumberGenerator().getNumber()

        //Accessing ViewModel
        var myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        txt_vm_number.text = myViewModel.getNumber()

        //LiveData access
        var viewModel = ViewModelProviders.of(this).get(MyViewModelWithLiveData::class.java)
        var liveData = viewModel.getLiveData()
        liveData?.observe(this, object: Observer<String>{
            override fun onChanged(t: String?) {
                txt_live_number. text = t
            }
        })
        btn_refresh.setOnClickListener {
            viewModel.getNumber()
        }
    }
}