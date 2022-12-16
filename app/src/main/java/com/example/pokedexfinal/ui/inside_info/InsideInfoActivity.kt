package com.example.pokedexfinal.ui.inside_info

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.pokedexfinal.R
import com.example.pokedexfinal.data.model.Pokemon
import com.example.pokedexfinal.databinding.ActivityInsideInfoBinding
import com.example.pokedexfinal.ui.inside_info.fragments.PokemonAboutFragment
import com.example.pokedexfinal.ui.inside_info.fragments.PokemonEvolutionsFragment
import com.example.pokedexfinal.ui.inside_info.fragments.PokemonMovementsFragment
import com.example.pokedexfinal.ui.inside_info.fragments.PokemonStatsFragment
import com.example.pokedexfinal.ui.inside_info.viewpager_adapter.ViewPagerAdapter
import com.example.pokedexfinal.utils.PokedexToolsFunctions
import com.google.android.material.tabs.TabLayoutMediator

class InsideInfoActivity : AppCompatActivity(), InsideInfoContract.View {

    lateinit var mPresenter : InsideInfoContract.Presenter
    lateinit var binding : ActivityInsideInfoBinding

    lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInsideInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPresenter = InsideInfoWrapper.inject(this)

        viewPagerAdapter = ViewPagerAdapter(this)

        binding.viewpagerInsideinfo.adapter = viewPagerAdapter

        /*binding.insideinfoScrollview.viewTreeObserver.addOnScrollChangedListener {

            if(binding.insideinfoScrollview.scrollY < 150){
                //binding.appBarLayout.animate().alpha(0.0f).withEndAction { binding.appBarLayout.visibility = View.GONE }

                //binding.fancyName.animate().alpha(1.0f).withStartAction { binding.fancyName.visibility = View.VISIBLE }
            }else{
                //binding.appBarLayout.animate().alpha(1.0f).withStartAction { binding.appBarLayout.visibility = View.VISIBLE }

                //binding.fancyName.animate().alpha(0.0f).withEndAction { binding.fancyName.visibility = View.GONE }
            }

        }*/


        TabLayoutMediator(binding.tablayoutInsideinfo, binding.viewpagerInsideinfo){
          tab,position ->

            tab.text = when(position){

                0 -> "Acerca de"
                1 -> "Puntos de Base"
                2 -> "Evoluciones"
                3 -> "Movimientos"
                else -> ""
            }
            binding.insideinfoScrollview.smoothScrollTo(0, 0)
            binding.insideinfoScrollview.scrollY = 100
        }.attach()

        /*
        binding.backArrow.setOnClickListener {
            mPresenter.toMainActivity()
            finish()
        }*/

        setSupportActionBar(binding.insideinfoToolbar)

        mPresenter.getPokemon(intent.getIntExtra("pokemonId",  0)+1)

    }

    override fun updateUI(pk: Pokemon) {

        Glide.with(this).load(pk.sprites!!.other!!.artwork!!.sprite).into(binding.pokemonArtworkImage)
        val name = pk.name?.get(0)!!.uppercase()+pk.name!!.substring(1)
        //binding.pokemonNameText.setText(name)
        binding.collapsingToolbar.title = name
        binding.pokemonIdText.setText("#${pk.id!!}")
        binding.insideinfoLayout.setBackgroundColor(ContextCompat.getColor(this, PokedexToolsFunctions.getBackgroundTypeColor(pk.types?.get(0)!!.type!!.name!!)))


        binding.pokemonCardTypeSlot0.setCardBackgroundColor(ContextCompat.getColor(this, PokedexToolsFunctions.getChipTypeColor(pk.types?.get(0)!!.type!!.name!!)))
        binding.pokemonTextTypeSlot0.setText(PokedexToolsFunctions.translateType(pk.types?.get(0)!!.type!!.name!!))

        if(pk.types!!.size > 1){
            binding.pokemonCardTypeSlot1.visibility = View.VISIBLE
            binding.pokemonTextTypeSlot1.setText(PokedexToolsFunctions.translateType(pk.types?.get(1)!!.type!!.name!!))
            binding.pokemonCardTypeSlot1.setCardBackgroundColor(ContextCompat.getColor(this, PokedexToolsFunctions.getChipTypeColor(pk.types?.get(1)!!.type!!.name!!)))
        }else{
            binding.pokemonCardTypeSlot1.visibility = View.GONE
        }

        viewPagerAdapter.pk = pk


    }
}