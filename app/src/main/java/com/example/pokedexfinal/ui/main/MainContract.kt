package com.example.pokedexfinal.ui.main

import com.example.pokedexfinal.data.model.Pokemon
import io.realm.Realm
import io.realm.RealmList

interface MainContract {

    interface View {
        fun initPokemonList(list : RealmList<Pokemon>)
    }

    interface Presenter {
        fun toLoginActivity()
        fun toInsideInfo(id : Int)
        fun getPokemonList()
        fun getRealmInteractorInstance() : Realm

    }

    interface Interactor {
        fun getAllPokemons()
        fun getRealmInstance() : Realm

    }

    interface InteractorOutput {
        fun pokemonListSuccessful(list : RealmList<Pokemon>)
        fun pokemonListFailed()

    }

    interface Router {
        fun presentLogin()
        fun presentInsideInfo(id : Int)
    }
}