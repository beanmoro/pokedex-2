package com.example.pokedexfinal.ui.inside_info.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedexfinal.databinding.FragmentMovementsBinding

class PokemonMovementsFragment : Fragment() {

    var _binding : FragmentMovementsBinding? = null
    val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovementsBinding.inflate(inflater, container, false)
        return binding.root
    }

}