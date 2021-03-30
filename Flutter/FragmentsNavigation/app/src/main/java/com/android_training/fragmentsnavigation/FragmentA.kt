package com.android_training.fragmentsnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_a.view.*

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_a, container, false)

        view.btn_navigateToB.setOnClickListener {

//            Navigation.createNavigateOnClickListener(R.id.action_fragmentA_to_fragmentB2)
            Navigation.findNavController(view).navigate(R.id.action_fragmentA_to_fragmentB2)

        }
        return view
    }

}