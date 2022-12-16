package com.example.pokedexfinal.ui.inside_info

import com.example.pokedexfinal.data.model.Pokemon

interface InsideInfoContract {

    interface View {
        fun updateUI(pk : Pokemon)
    }

    interface Presenter {
        fun toMainActivity()
        fun getPokemon(id : Int)
    }

    interface Interactor {
        fun getPokemon(id : Int)
    }

    interface InteractorOutput {
        fun pokemonLoadedSuccessfully( pk : Pokemon)
        fun pokemonLoadedFailed()
    }

    interface Router {
        fun presentMain()
    }
}