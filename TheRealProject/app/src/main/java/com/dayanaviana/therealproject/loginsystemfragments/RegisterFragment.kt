package com.dayanaviana.therealproject.loginsystemfragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dayanaviana.therealproject.R
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {

    private var listener: OnRegisterFragmentInteraction? = null

    interface OnRegisterFragmentInteraction{
        fun onRegisterFragmentClicked(user: User?)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_register, container, false)
        init(view)
        return view
    }
    private fun init(view: View){
        view.btn_submit.setOnClickListener {
            var name = edt_name.text.toString()
            var email = edt_email.text.toString()
            var password = edt_password.text.toString()

            var user = User(name,email,password)

            listener?.onRegisterFragmentClicked(user)
        }
        view.txt_registered.setOnClickListener {
            listener?.onRegisterFragmentClicked(null)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity1
    }
}