package com.example.pokedexfinal.ui.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedexfinal.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope

class LoginActivity : AppCompatActivity(), LoginContract.View {


    lateinit var mPresenter : LoginContract.Presenter
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = LoginWrapper.inject(this)
        mPresenter.downloadData()
        binding.googleButton.setOnClickListener {
            mPresenter.toMainActivity()
            finish()
        }

    }

    override fun updateDownloadInfoUI(index: Int) {
        binding.downloadBar.progress = index
        binding.downloadText.setText("${index}/151")
        if(binding.downloadBar.max != 151){
            binding.downloadBar.max = 151
        }

        if(index == 151) {
            binding.downloadText.animate().alpha(0.0f).withEndAction { binding.downloadText.visibility = View.GONE }
            binding.downloadBar.animate().alpha(0.0f).withEndAction { binding.downloadBar.visibility = View.GONE }
            binding.googleButton.animate().alpha(1.0f).withEndAction { binding.googleButton.visibility = View.VISIBLE }
        }
    }
}