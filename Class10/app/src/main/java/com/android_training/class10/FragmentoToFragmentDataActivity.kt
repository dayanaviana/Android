package com.android_training.class10

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_data_from_fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class FragmentoToFragmentDataActivity : AppCompatActivity(), ButtonFragment.OnFragmentInteraction {

    var name :String = ""
    var id:Int = 0
    var email :String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmento_to_fragment_data)

        var frag_transaction = supportFragmentManager.beginTransaction()
        frag_transaction.add(R.id.frame_102, ButtonFragment())
        frag_transaction.add(R.id.frame_103, BlankFragment())
        frag_transaction.commit()

    }

    override fun onButtonClicked(name: String,id:Int,email:String) {
        this.name = name
        this.email = email
        this.id = id

        var blankFragment = BlankFragment.newInstance(id,name,email)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_103, blankFragment)
            .commit()
    }

    override fun onButtonClicked(bundle: Bundle) {
        this.name = bundle.getString("NAME").toString()
        this.id = bundle.getInt("ID")
        this.email = bundle.getString("EMAIL").toString()

        var blankFragment = BlankFragment.newInstance(id,name,email)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_103, blankFragment)
            .commit()
    }

}