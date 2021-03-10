package com.dayanaviana.therealproject.loginsystemfragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dayanaviana.therealproject.R
import com.dayanaviana.therealproject.loginsystem.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.btn_login
import kotlinx.android.synthetic.main.fragment_login.edt_email
import kotlinx.android.synthetic.main.fragment_login.edt_password
import kotlinx.android.synthetic.main.fragment_login.txt_error
import kotlinx.android.synthetic.main.fragment_login.txt_new_user
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_register.*

class LoginFragment : Fragment() {

    private var user: User? = null

    private var listener: OnLoginFragmentInteraction? = null

    interface OnLoginFragmentInteraction{
        fun onLoginFragmentClicked(user: User?)
        fun onNewUserClicked()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            var u: User? = it.getSerializable(User.USER_DATA) as User
            this.user = u
            Log.d("debugin", "LoginFragment onCreate")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        init(view)
        return view
    }
    private fun init(view: View){
        view.btn_login.setOnClickListener {
            var email = edt_email.text.toString()
            var password = edt_password.text.toString()
            var name = "Admin"
            if(verifyLogin()){
                var user = User(name, email, password)
                listener?.onLoginFragmentClicked(user)
            }
        }
        view.txt_new_user.setOnClickListener {
            listener?.onNewUserClicked()
        }
    }

    private fun verifyLogin(): Boolean{
        var email = edt_email.text.toString()
        var password = edt_password.text.toString()
        if (email == "admin" && password == "123") {
            txt_error.text = ""
            return true
        }else if(email == this.user?.email && password == user?.password){
            txt_error.text = ""
            return true
        }
        else{
            txt_error.text = "Invalid Username or Password"
            return false
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity1
    }

    companion object {

        @JvmStatic
        fun newInstance(user: User?) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(User.USER_DATA, user)
                }
            }
    }
}