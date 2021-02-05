package com.dayanaviana.therealproject.loginsystemfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dayanaviana.therealproject.R
import kotlinx.android.synthetic.main.fragment_auth.view.*


class AuthFragment : Fragment() {

    interface OnAuthFragmentInteraction{
        fun onAuthFragmentClicked(name: String)
    }
    private var listener: OnAuthFragmentInteraction? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_auth, container, false)
        init(view)
        return view
    }
    private fun init(view: View){
        view.btn_login_main.setOnClickListener {
            listener?.onAuthFragmentClicked("LOGIN")
        }
        view.btn_register.setOnClickListener {
            listener?.onAuthFragmentClicked("REGISTER")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity1
    }
}