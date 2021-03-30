package com.android_training.fragmentsnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.android_training.fragmentsnavigation.databinding.FragmentBBinding
import kotlinx.android.synthetic.main.fragment_a.view.*
import kotlinx.android.synthetic.main.fragment_b.view.*

class FragmentB : Fragment() {
    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater,container,false)

        sharedViewModel.country.observe(viewLifecycleOwner, {country ->
            binding.edtCountryB.setText(country)
        })

        binding.btnNavigateToA.setOnClickListener {
//            Navigation.createNavigateOnClickListener(R.id.action_fragmentB_to_fragmentA)
            Navigation.findNavController(it).navigate(R.id.action_fragmentB_to_fragmentA)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}