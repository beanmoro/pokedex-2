package com.example.pokedexfinal.ui.main

import com.example.pokedexfinal.data.model.Pokemon
import io.realm.Realm
import io.realm.RealmList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainPresenter(override val coroutineContext: CoroutineContext) : MainContract.Presenter, MainContract.InteractorOutput, CoroutineScope {

    lateinit var mView : MainContract.View
    lateinit var mInteractor : MainContract.Interactor
    lateinit var mRouter: MainContract.Router

    override fun toLoginActivity() {
        mRouter.presentLogin()
    }

    override fun toInsideInfo(id : Int) {
        mRouter.presentInsideInfo(id)
    }

    override fun getPokemonList() {
        //launch(Dispatchers.IO) {
            mInteractor.getAllPokemons()
        //}
    }

    override fun getRealmInteractorInstance(): Realm {
        return mInteractor.getRealmInstance()
    }

    override fun pokemonListSuccessful(list: RealmList<Pokemon>) {
        mView.initPokemonList(list)
    }

    override fun pokemonListFailed() {
    }
}