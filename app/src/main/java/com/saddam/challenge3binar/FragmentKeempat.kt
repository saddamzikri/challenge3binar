package com.saddam.challenge3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.saddam.challenge3binar.R
import com.saddam.challenge3binar.Atribute
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
            button.setOnClickListener {
                val nama = edtName.text.toString()
                val umur = edtUsia.text.toString().toInt()
                val alamat = edtAlamat.text.toString()
                val pekerjaan = edtPekerjaan.text.toString()

                if (edtName.text.isNullOrEmpty() || edtUsia.text.isNullOrEmpty() || edtAlamat.text.isNullOrEmpty() || edtPekerjaan.text.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "Lengkapi Data Anda !", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val atribute = Atribute(nama, umur, alamat, pekerjaan)
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