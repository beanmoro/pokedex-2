package com.example.pokedexfinal.ui.login

import android.app.Activity
import com.example.pokedexfinal.data.network.APIHelperImpl
import com.example.pokedexfinal.data.network.RestClient
import io.realm.Realm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

object LoginWrapper {

    fun inject(view : LoginContract.View) : LoginContract.Presenter{
        val presenter = LoginPresenter(Dispatchers.Main)
        val interactor = LoginInteractor(Dispatchers.IO)
        val router = LoginRouter()

        interactor.mOutput = presenter
        interactor.realm = Realm.getDefaultInstance()
        router.mActivity = view as Activity
        interactor.apiHelper = APIHelperImpl(RestClient.instance)


        presenter.mView = view
        presenter.mInteractor = interactor
        presenter.mRouter = router

        return presenter
    }
}