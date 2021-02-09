package com.android_training.class9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android_training.R
import kotlinx.android.synthetic.main.fragment_one.view.*

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_one, container, false)

        view.btn_frag1.setOnClickListener {
            Toast.makeText(activity, "Button Clicked", Toast.LENGTH_SHORT).show()
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, FragmentTwo())
                .addToBackStack("")
                .commit()
        }
        return view
    }
}