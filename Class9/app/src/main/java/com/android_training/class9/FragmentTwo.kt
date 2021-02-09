package com.android_training.class9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android_training.R
import kotlinx.android.synthetic.main.fragment_two.view.*

class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_two, container, false)

        view.btn_frag2.setOnClickListener {

//            activity!!
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, FragmentThree())
                .addToBackStack("")
                .commit()

        }

        return view
    }
}