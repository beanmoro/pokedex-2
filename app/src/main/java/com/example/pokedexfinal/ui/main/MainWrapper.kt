package com.example.pokedexfinal.ui.main

import android.app.Activity
import io.realm.Realm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

object MainWrapper {

    fun inject(view : MainContract.View) : MainContract.Presenter {
        val presenter = MainPresenter(Dispatchers.Main)
        val interactor = MainInteractor(/*Dispatchers.IO*/)
        val router = MainRouter()

        interactor.mOutput = presenter
        interactor.realm = Realm.getDefaultInstance()
        router.mActivity = view as Activity

        //presenter.scope = presenterScope
        presenter.mView = view
        presenter.mInteractor = interactor
        presenter.mRouter = router

        return presenter
    }
}