package com.saddam.challenge3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.saddam.challenge3binar.databinding.FragmentKeempatBinding

class FragmentKeempat : Fragment() {

    private var _binding: FragmentKeempatBinding? = null
    private val binding get() = _binding!!

    private val args: FragmentKeempatArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKeempatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            edtName.setText(args.name)
            btnScreen4.setOnClickListener {
                val nama = edtName.text.toString()
                val gaji = edtGaji.text.toString().toInt()
                val iuranBulanan = edtIuranBulanan.text.toString().toInt()
                val belanja = edtBelanja.text.toString().toInt()

                if (edtName.text.isNullOrEmpty() || edtGaji.text.isNullOrEmpty() || edtIuranBulanan.text.isNullOrEmpty() || edtBelanja.text.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "Lengkapi Data Anda !", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val atribute = Atribute(nama, gaji, iuranBulanan, belanja)
                    findNavController().navigate(
                        FragmentKeempatDirections.actionFragmentKeempatToFragmentKetiga(
                            atribute
                        )
                    )

                }
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}