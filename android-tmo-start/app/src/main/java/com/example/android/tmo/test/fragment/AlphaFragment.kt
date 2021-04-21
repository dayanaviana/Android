package com.example.android.tmo.test.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.tmo.test.R
import com.example.android.tmo.test.viewmodel.AlphaViewModel

/**
 * Create a fragment that has buttons that go to Beta Fragment and Gamma Fragment.
 */
class AlphaFragment : Fragment() {

    companion object {
        fun newInstance() = AlphaFragment()
    }

    private lateinit var viewModel: AlphaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alpha_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlphaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}