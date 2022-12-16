package com.example.pokedexfinal.ui.inside_info.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedexfinal.data.model.Pokemon
import com.example.pokedexfinal.databinding.FragmentAboutBinding

class PokemonAboutFragment() : Fragment() {

    var _binding : FragmentAboutBinding? = null
    val binding get() = _binding!!
    lateinit var pokemon : Pokemon


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)

        //binding.weightText.setText("${pokemon.weight} Kg")
        //binding.heightText.setText("${pokemon.height} M")
        //binding.skillText.setText(pokemon.abilities!!.get(0)!!.name)
        //binding.typeSlot0Text.setText(pokemon.types!!.get(0)!!.type!!.name)

        return binding.root
    }




}