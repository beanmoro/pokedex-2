package com.example.pokedexfinal.ui.main

import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexfinal.R
import com.example.pokedexfinal.data.model.Pokemon
import com.example.pokedexfinal.databinding.ActivityMainBinding
import com.example.pokedexfinal.ui.main.adapter.MainAdapter
import io.realm.RealmList

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var mPresenter : MainContract.Presenter
    lateinit var binding : ActivityMainBinding
    lateinit var adapter : MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = MainWrapper.inject(this)

        binding.filterView.visibility = View.GONE


        binding.logoutBtn.setOnClickListener {
            mPresenter.toLoginActivity()
            finish()
        }

        binding.filterBtn.setOnClickListener {

            if(binding.filterView.visibility == View.VISIBLE){
                binding.filterBtn.setImageResource(R.drawable.ic_filter)

                binding.filterView.animate().alpha(0.0f).withEndAction {
                    binding.filterView.visibility = View.GONE
                }

            }else{
                binding.filterBtn.setImageResource(R.drawable.ic_filter__1_)
                binding.filterView.animate().alpha(1.0f).withStartAction {
                    binding.filterView.visibility = View.VISIBLE
                }
            }
        }

        adapter = MainAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter

        adapter.onItemClick = {
            mPresenter.toInsideInfo(it)
        }

        mPresenter.getPokemonList()

    }

    override fun initPokemonList(list: RealmList<Pokemon>) {
        adapter.pokemonList = list
    }
}