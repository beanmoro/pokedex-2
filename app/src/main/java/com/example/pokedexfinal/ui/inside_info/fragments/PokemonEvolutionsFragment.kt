package com.example.pokedexfinal.ui.inside_info.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexfinal.databinding.FragmentEvolutionsBinding
import com.example.pokedexfinal.ui.inside_info.fragments.adapter.PokemonEvolutionsAdapter

class PokemonEvolutionsFragment : Fragment(){

    var _binding : FragmentEvolutionsBinding? = null
    val binding get() = _binding!!
    lateinit var adapter : PokemonEvolutionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEvolutionsBinding.inflate(inflater, container, false)

        adapter = PokemonEvolutionsAdapter()
        binding.evolutionsRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.evolutionsRecycler.adapter = adapter


        return binding.root
    }
}