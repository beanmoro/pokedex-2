package com.example.pokedexfinal.data.network

import com.example.pokedexfinal.data.model.Evolution
import com.example.pokedexfinal.data.model.EvolutionChain
import com.example.pokedexfinal.data.model.Pokemon
import com.example.pokedexfinal.data.model.PokemonList

interface APIHelper {

    suspend fun pokemon(query : String) : Pokemon?

    suspend fun allPokemon() : PokemonList?

    suspend fun pokemonEvolution(id : String) : Evolution?

}