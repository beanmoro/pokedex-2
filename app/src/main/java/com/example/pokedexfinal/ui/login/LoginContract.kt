package com.example.pokedexfinal.ui.login

interface LoginContract {

    interface View {
        fun updateDownloadInfoUI( index : Int)
    }

    interface Presenter {
        fun toMainActivity()
        fun downloadData()
    }

    interface Interactor {
        suspend fun downloadPokemons()

    }

    interface InteractorOutput {
        fun downloadSuccesful()
        fun downloadFailed()
        fun updateDownloadInfo( index : Int)
    }

    interface Router {
        fun presentMain()
    }
}