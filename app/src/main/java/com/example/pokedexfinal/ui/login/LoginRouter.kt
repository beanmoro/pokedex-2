package com.example.pokedexfinal.ui.login

import android.app.Activity
import android.content.Intent
import com.example.pokedexfinal.ui.main.MainActivity

class LoginRouter : LoginContract.Router {

    lateinit var mActivity : Activity

    override fun presentMain() {
        val intent = Intent(mActivity, MainActivity::class.java)
        mActivity.startActivity(intent)
    }


}