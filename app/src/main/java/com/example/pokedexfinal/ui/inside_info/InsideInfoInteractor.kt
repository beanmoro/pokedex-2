package com.example.pokedexfinal.ui.inside_info

import com.example.pokedexfinal.data.local.LocalDataManager
import io.realm.Realm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class InsideInfoInteractor(override val coroutineContext: CoroutineContext) : InsideInfoContract.Interactor, CoroutineScope {

    lateinit var mOutput: InsideInfoContract.InteractorOutput
    lateinit var realm : Realm

    override fun getPokemon(id: Int) {

        val pkmn = LocalDataManager.loadPokemonById(id, realm)

        if(pkmn != null){
            launch(Dispatchers.Main) {
                mOutput.pokemonLoadedSuccessfully(pkmn)
            }
        }else{
            launch(Dispatchers.Main) {
                mOutput.pokemonLoadedFailed()
            }
        }
    }
}