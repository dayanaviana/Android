package com.example.android.tmo.test.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.tmo.test.R
import com.example.android.tmo.test.viewmodel.GammaViewModel

/**
 * Create a fragment that has a button that makes an API call to get cat facts. Display them.
 */
class GammaFragment : Fragment() {

    companion object {
        fun newInstance() = GammaFragment()
    }

    private lateinit var viewModel: GammaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gamma_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GammaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}