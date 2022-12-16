package com.example.pokedexfinal.data.network

import com.example.pokedexfinal.data.model.Evolution
import com.example.pokedexfinal.data.model.EvolutionChain
import com.example.pokedexfinal.data.model.Pokemon
import com.example.pokedexfinal.data.model.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface API {

    @GET()
    suspend fun getPokemon(@Url url : String) : Response<Pokemon>

    @GET("pokemon/?offset=0&limit=151")
    suspend fun getAllPokemon() : Response<PokemonList>

    @GET()
    suspend fun getPokemonEvolution(@Url id: String) : Response<Evolution>


}