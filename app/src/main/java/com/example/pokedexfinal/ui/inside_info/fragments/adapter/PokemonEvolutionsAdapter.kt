package com.example.pokedexfinal.ui.inside_info.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfinal.R
import com.example.pokedexfinal.databinding.ItemEvolutionBinding

class PokemonEvolutionsAdapter : RecyclerView.Adapter<PokemonEvolutionsAdapter.EvolutionViewHolder>() {

    inner class EvolutionViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val binding = ItemEvolutionBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EvolutionViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_evolution, parent, false)

        return EvolutionViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: EvolutionViewHolder, position: Int) {
    }

    override fun getItemCount(): Int  = 2
}