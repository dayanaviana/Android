package com.android_training.class5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_edit_text.*

class EditTextActivity : AppCompatActivity(), View.OnClickListener {
    var num1:Double = 0.0
    var num2:Double = 0.0
    var result:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        init()
    }

    private fun init(){
        btn_add.setOnClickListener (this)
        btn_divide.setOnClickListener(this)
        btn_subtract.setOnClickListener(this)
        btn_multiply.setOnClickListener(this)
    }
    override fun onClick(view: View) {
        hideKeybord(view)

        num1 = edit_text_number1.text.toString().toDouble() ?: 0.0
        num2 = edit_text_number2.text.toString().toDouble() ?: 0.0
        when (view.id) {
            R.id.btn_add -> result = num1+num2
            R.id.btn_subtract -> result = num1-num2
            R.id.btn_multiply -> result = num1*num2
            R.id.btn_divide -> result = num1/num2
        }
        text_result.text = result.toString()
    }

    fun hideKeybord(view: View){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }

}