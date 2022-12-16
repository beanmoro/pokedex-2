package com.example.pokedexfinal.ui.login

import android.util.Log
import com.example.pokedexfinal.data.local.LocalDataManager
import com.example.pokedexfinal.data.network.APIHelper
import io.realm.Realm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginInteractor(override val coroutineContext: CoroutineContext) : LoginContract.Interactor, CoroutineScope {

    lateinit var mOutput : LoginContract.InteractorOutput
    lateinit var apiHelper : APIHelper
    lateinit var realm : Realm

    override suspend fun downloadPokemons() {

        val allPokemons = apiHelper.allPokemon()!!.results

        var index = 0
        allPokemons!!.map { pokemonGeneral ->
            val pkmn = apiHelper.pokemon(pokemonGeneral.name!!)
            if(pkmn != null){
                LocalDataManager.savePokemonToLocalData(pkmn, realm)
                val pkmn_evol = apiHelper.pokemonEvolution(pkmn.id!!.toString())
                if(pkmn_evol != null) {
                    LocalDataManager.savePokemonEvolution(pkmn_evol, realm)
                }
                index++
                launch(Dispatchers.Main) {
                    mOutput.updateDownloadInfo(index)
                }
            }
        }
    }
}