package com.example.pokedexfinal.data.network

import android.util.Log
import com.example.pokedexfinal.data.model.Evolution
import com.example.pokedexfinal.data.model.EvolutionChain
import com.example.pokedexfinal.data.model.Pokemon
import com.example.pokedexfinal.data.model.PokemonList
import java.lang.Exception

class APIHelperImpl(private val apiInstance : API) : APIHelper {


    override suspend fun pokemon(query: String): Pokemon? {
        try{
            return apiInstance.getPokemon("pokemon/$query").body()
        }catch (e: Exception){
            Log.e("API_ERROR", "API ERROR: ${e.message}")
        }
        return null
    }

    override suspend fun allPokemon(): PokemonList? {
        try{
            return apiInstance.getAllPokemon().body()
        }catch (e : Exception){
            Log.e("API_ERROR", "API ERROR: ${e.message}")
        }
        return null
    }

    override suspend fun pokemonEvolution(id : String): Evolution? {
        try{
            return apiInstance.getPokemonEvolution("evolution-chain/${id}").body()

        }catch (e: Exception){
            Log.e("API_ERROR", "API ERROR: ${e.message}")

        }
        return null
    }
}