package com.saddam.challenge3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.saddam.challenge3binar.databinding.FragmentKeduaBinding


class FragmentKedua : Fragment() {

    private var _binding: FragmentKeduaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeduaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScreen2.setOnClickListener {
            if (binding.edtName.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Kolom Nama Masih Kosong !", Toast.LENGTH_SHORT).show()
            }
            else {
                val name = _binding?.edtName?.text!!
                val atribute = Atribute(name)
                val action = FragmentKeduaDirections.actionFragmentKeduaToFragmentKetiga(atribute)
                it.findNavController().navigate(action)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}