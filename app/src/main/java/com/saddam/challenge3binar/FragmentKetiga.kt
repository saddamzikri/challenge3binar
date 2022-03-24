package com.saddam.challenge3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.saddam.challenge3binar.R
import com.saddam.challenge3binar.databinding.FragmentKetigaBinding

class FragmentKetiga : Fragment() {

    private var _binding: FragmentKetigaBinding? = null
    private val binding
        get() = _binding!!

    private val args: FragmentKetigaArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKetigaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = args.atribute?.name
        val usia = args.atribute?.umur
        val alamat = args.atribute?.alamat
        val pekerjaan = args.atribute?.pekerjaan

        binding.btnScreen3.setOnClickListener {
            findNavController().navigate(FragmentKetigaDirections.actionFragmentKetigaToFragmentKeempat(name!!))
        }

        if (alamat == null && pekerjaan == null && usia == null){
            binding.txtYourname.text = name
        } else {
            with(binding){
                txtYourname.visibility = View.INVISIBLE
                binding.viewFullIdentity.atributeDetail.visibility = View.VISIBLE
                binding.viewFullIdentity.tvFullname.text = name
                binding.viewFullIdentity.tvAlamat.text = alamat
                binding.viewFullIdentity.tvPekerjaan.text = pekerjaan

                if (args.atribute!!.umur?.rem(2) == 0){
                    viewFullIdentity.tvAge.text = getString(R.string.umur, usia, "genap")
                } else {
                    viewFullIdentity.tvAge.text = getString(R.string.umur, usia, "ganjil")
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }

}