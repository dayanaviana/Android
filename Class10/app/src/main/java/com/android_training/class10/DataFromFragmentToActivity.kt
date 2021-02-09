package com.android_training.class10

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_data_from_fragment.*

class DataFromFragmentToActivity : AppCompatActivity(), ButtonFragment.OnFragmentInteraction {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_from_fragment)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container101, ButtonFragment())
            .commit()

    }

    override fun onButtonClicked(name: String,id:Int,email:String) {
        text_view_name101.text = "$id \n $name \n $email"
    }

    override fun onButtonClicked(bundle: Bundle) {
        TODO("Not yet implemented")
    }

}