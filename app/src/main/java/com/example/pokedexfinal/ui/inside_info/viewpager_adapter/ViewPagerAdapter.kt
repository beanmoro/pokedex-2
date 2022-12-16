package com.example.pokedexfinal.ui.inside_info.viewpager_adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pokedexfinal.data.model.Pokemon
import com.example.pokedexfinal.ui.inside_info.fragments.PokemonAboutFragment
import com.example.pokedexfinal.ui.inside_info.fragments.PokemonEvolutionsFragment
import com.example.pokedexfinal.ui.inside_info.fragments.PokemonMovementsFragment
import com.example.pokedexfinal.ui.inside_info.fragments.PokemonStatsFragment

class ViewPagerAdapter(
    activity : AppCompatActivity
    ) : FragmentStateAdapter(activity)
{
    lateinit var pk : Pokemon

    val items : ArrayList<Fragment> = arrayListOf(
        PokemonAboutFragment(),
        PokemonStatsFragment(),
        PokemonEvolutionsFragment(),
        PokemonMovementsFragment()
    )



    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}