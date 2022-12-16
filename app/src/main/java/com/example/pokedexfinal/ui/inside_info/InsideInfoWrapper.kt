package com.example.pokedexfinal.ui.inside_info

import android.app.Activity
import io.realm.Realm
import kotlinx.coroutines.Dispatchers

object InsideInfoWrapper {

    fun inject(view : InsideInfoContract.View) : InsideInfoContract.Presenter {
        val presenter = InsideInfoPresenter(Dispatchers.Main)
        val interactor = InsideInfoInteractor(Dispatchers.IO)
        val router = InsideInfoRouter()

        interactor.mOutput = presenter
        interactor.realm = Realm.getDefaultInstance()
        router.mActivity = view as Activity

        presenter.mView = view
        presenter.mInteractor = interactor
        presenter.mRouter = router

        return presenter
    }
}