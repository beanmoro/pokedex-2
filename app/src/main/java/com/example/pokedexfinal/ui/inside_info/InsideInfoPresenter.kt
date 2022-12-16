package com.example.pokedexfinal.ui.inside_info

import com.example.pokedexfinal.data.model.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class InsideInfoPresenter(override val coroutineContext: CoroutineContext) : InsideInfoContract.Presenter, InsideInfoContract.InteractorOutput, CoroutineScope {

    lateinit var mView : InsideInfoContract.View
    lateinit var mInteractor: InsideInfoContract.Interactor
    lateinit var mRouter: InsideInfoContract.Router

    override fun toMainActivity() {
        mRouter.presentMain()
    }

    override fun getPokemon(id: Int) {
        //launch(Dispatchers.IO) {
            mInteractor.getPokemon(id)
        //}
    }

    override fun pokemonLoadedSuccessfully(pk: Pokemon) {
        mView.updateUI(pk)
    }

    override fun pokemonLoadedFailed() {
        TODO("Not yet implemented")
    }
}