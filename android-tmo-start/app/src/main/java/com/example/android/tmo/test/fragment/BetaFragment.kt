package com.example.android.tmo.test.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.tmo.test.R
import com.example.android.tmo.test.viewmodel.BetaViewModel

/**
 * Create a fragment that has a button that go to Gamma Fragment.
 */
class BetaFragment : Fragment() {

    companion object {
        fun newInstance() = BetaFragment()
    }

    private lateinit var viewModel: BetaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.beta_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BetaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}