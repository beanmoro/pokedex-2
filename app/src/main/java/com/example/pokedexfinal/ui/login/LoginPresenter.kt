package com.example.pokedexfinal.ui.login

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginPresenter(override val coroutineContext: CoroutineContext) : LoginContract.Presenter, LoginContract.InteractorOutput, CoroutineScope {

    lateinit var mView : LoginContract.View
    lateinit var mInteractor: LoginContract.Interactor
    lateinit var mRouter : LoginContract.Router

    override fun toMainActivity() {
        mRouter.presentMain()
    }

    override fun downloadData() {
        //launch(Dispatchers.IO) {
        //mInteractor.downloadPokemons()
        //}
        launch {
            mInteractor.downloadPokemons()
        }
    }

    override fun downloadSuccesful() {
        TODO("Not yet implemented")
    }

    override fun downloadFailed() {
        TODO("Not yet implemented")
    }

    override fun updateDownloadInfo(index: Int) {
        mView.updateDownloadInfoUI(index)
    }
}