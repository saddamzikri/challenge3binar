package com.saddam.challenge3binar

import android.annotation.SuppressLint
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
        val gaji = args.atribute?.gaji.toString().toInt()
        val iuranBulanan = args.atribute?.iuranBulanan.toString().toInt()
        val belanja = args.atribute?.belanja.toString().toInt()
        // val pengeluaran = gaji + iuranBulanan - belanja

        binding.btnScreen3.setOnClickListener {
            findNavController().navigate(FragmentKetigaDirections.actionFragmentKetigaToFragmentKeempat(name!!))
        }

        if (gaji == null && iuranBulanan == null && belanja == null){
            binding.txtYourname.text = name
        } else {
            with(binding){
                txtYourname.visibility = View.INVISIBLE
                binding.viewFullIdentity.atributeDetail.visibility = View.VISIBLE
                binding.viewFullIdentity.tvGaji.text = gaji.toString()
                binding.viewFullIdentity.tvIuranBulanan.text = iuranBulanan.toString()
                binding.viewFullIdentity.tvBelanja.text = belanja.toString()
                // binding.viewFullIdentity.tvPengeluaran.text = pengeluaran.toString()

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }

}