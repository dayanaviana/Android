//Source: https://www.youtube.com/watch?v=THt9QISnIMQ

package com.android_training.fragmentsnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.android_training.fragmentsnavigation.databinding.FragmentABinding
import kotlinx.android.synthetic.main.fragment_a.view.*

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

//    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        var view = inflater.inflate(R.layout.fragment_a, container, false)
        _binding = FragmentABinding.inflate(inflater,container,false)

        var sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        sharedViewModel.country.observe(viewLifecycleOwner, {country ->
            binding.edtCountryA.setText(country)
        })

        binding.btnNavigateToB.setOnClickListener {
            sharedViewModel.saveCountry(binding.edtCountryA.text.toString())
            Navigation.findNavController(it).navigate(R.id.action_fragmentA_to_fragmentB2)

        }
        return binding.root
//        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}