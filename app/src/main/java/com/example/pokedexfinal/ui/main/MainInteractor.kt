package com.example.pokedexfinal.ui.main

import com.example.pokedexfinal.data.local.LocalDataManager
import com.example.pokedexfinal.data.model.Pokemon
import io.realm.Realm
import io.realm.RealmList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainInteractor(/*override val coroutineContext: CoroutineContext*/) : MainContract.Interactor/*, CoroutineScope*/ {

    lateinit var mOutput : MainContract.InteractorOutput
    lateinit var realm : Realm

    init {
        //launch{
            realm = Realm.getDefaultInstance()
        //}
    }

    override fun getAllPokemons() {

        val pokemonList : RealmList<Pokemon> = LocalDataManager.loadAllPokemonFromLocalData(realm)

        if(pokemonList != null){
            mOutput.pokemonListSuccessful(pokemonList)
        }else{
            mOutput.pokemonListFailed()
        }
    }

    override fun getRealmInstance(): Realm {
        return realm
    }
}