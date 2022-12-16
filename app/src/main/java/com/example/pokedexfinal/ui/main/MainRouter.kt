package com.example.pokedexfinal.ui.main

import android.app.Activity
import android.content.Intent
import com.example.pokedexfinal.ui.inside_info.InsideInfoActivity
import com.example.pokedexfinal.ui.login.LoginActivity

class MainRouter : MainContract.Router {

    lateinit var mActivity : Activity

    override fun presentLogin() {
        val intent = Intent(mActivity, LoginActivity::class.java)
        mActivity.startActivity(intent)
    }

    override fun presentInsideInfo(id : Int) {
        val intent = Intent(mActivity, InsideInfoActivity::class.java)
        intent.putExtra("pokemonId", id)
        mActivity.startActivity(intent)
    }
}