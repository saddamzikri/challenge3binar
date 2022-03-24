package com.saddam.challenge3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.saddam.challenge3binar.databinding.FragmentPertamaBinding


class FragmentPertama : Fragment() {

    private var _binding: FragmentPertamaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPertamaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScreen1.setOnClickListener {
            findNavController().navigate(FragmentPertamaDirections.actionFragmentPertamaToFragmentKedua())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}