package com.dayanaviana.therealproject.loginsystemfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.dayanaviana.therealproject.R

class MainActivity1 : AppCompatActivity(),
    AuthFragment.OnAuthFragmentInteraction,
    RegisterFragment.OnRegisterFragmentInteraction,
    LoginFragment.OnLoginFragmentInteraction {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        init()
    }
    private fun init(){
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_main1, AuthFragment())
            .commit()
    }
    //AuthFragment Interface
    override fun onAuthFragmentClicked(name: String) {
        when(name){
            "LOGIN" -> replaceFragment(LoginFragment())
            "REGISTER" -> replaceFragment(RegisterFragment())
        }
    }
    //RegisterFragment Interface
    override fun onRegisterFragmentClicked(newUser: User?) {
        Log.d("debugin","Button Register Clicked!")
        var fragment = LoginFragment.newInstance(newUser)
        replaceFragment(fragment)
    }
    //LoginFragment Interface
    override fun onLoginFragmentClicked(user: User?) {
//        var fragment = HomeFragment.newInstance(newUser)
//        replaceFragment(fragment)
        replaceFragment(HomeFragment())
    }
    //LoginFragment Interface
    override fun onNewUserClicked() {
        replaceFragment(RegisterFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main1, fragment)
            .addToBackStack("")
            .commit()
    }
}