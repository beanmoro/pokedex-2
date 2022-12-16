package com.example.pokedexfinal.ui.main.adapter

import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cl.jumpitt.negociofacil.utils.capitalizeWords
import com.bumptech.glide.Glide
import com.example.pokedexfinal.R
import com.example.pokedexfinal.data.model.Pokemon
import com.example.pokedexfinal.databinding.CardPokemonBinding
import com.example.pokedexfinal.utils.PokedexToolsFunctions
import io.realm.Realm
import io.realm.RealmList
import okhttp3.internal.toHexString

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var onItemClick : ((Int)->Unit)? = null
    var pokemonList : RealmList<Pokemon>? = null


    inner class MainViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val binding = CardPokemonBinding.bind(view)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon, parent, false)
        return MainViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val item = pokemonList?.get(position)

        if(item != null){

            val pName = item.name?.get(0)!!.uppercase()+item.name!!.substring(1)
            holder.binding.textiviewName.setText(pName)

            holder.binding.textviewId.setText("#${item.id}")
            Glide.with(holder.binding.imageviewArtwork.context).load(item.sprites!!.other!!.artwork!!.sprite).into(holder.binding.imageviewArtwork)




            val bColor : Int = PokedexToolsFunctions.getBackgroundTypeColor(item.types!!.get(0)!!.type!!.name!!)
                /*when(item.types!!.get(0)!!.type!!.name) {

                "grass" -> R.color.grass
                "fire" -> R.color.fire
                "water" -> R.color.water
                "electric" -> R.color.electric
                "poison" -> R.color.poison
                "psychic" -> R.color.psychic
                "flying" -> R.color.flying
                "ice" -> R.color.ice
                "rock" -> R.color.rock
                else -> R.color.black


            }*/

            Log.d("Pokemon", "PokemonCardColor: ${bColor.toHexString()} -> ${item.name}")
            holder.binding.card.setCardBackgroundColor(ContextCompat.getColor(holder.binding.card.context, bColor))


            val slot0ColorChip : Int = PokedexToolsFunctions.getChipTypeColor(item.types!!.get(0)!!.type!!.name!!)
            /*
                when(item.types!!.get(0)!!.type!!.name){
                "grass" -> R.color.grassChip
                "fire" -> R.color.fireChip
                "water" -> R.color.waterChip
                "electric" -> R.color.electricChip
                "poison" -> R.color.poisonChip
                "psychic" -> R.color.psychicChip
                "flying" -> R.color.flyingChip
                "ice" -> R.color.iceChip
                "rock" -> R.color.rockChip
                else -> R.color.black
            }*/



            holder.binding.cardTypeSlot0.setCardBackgroundColor(ContextCompat.getColor(holder.binding.cardTypeSlot0.context, slot0ColorChip))
            holder.binding.textTypeSlot0.setText(PokedexToolsFunctions.translateType(item.types!!.get(0)!!.type!!.name!!))

            if(item.types!!.size > 1){

                val slot1ColorChip : Int = PokedexToolsFunctions.getChipTypeColor(item.types!!.get(1)!!.type!!.name!!)

                    /*when(item.types!!.get(1)!!.type!!.name){
                    "grass" -> R.color.grassChip
                    "fire" -> R.color.fireChip
                    "water" -> R.color.waterChip
                    "electric" -> R.color.electricChip
                    "poison" -> R.color.poisonChip
                    "psychic" -> R.color.psychicChip
                    "flying" -> R.color.flyingChip
                    "ice" -> R.color.iceChip
                    "rock" -> R.color.rockChip
                    else -> R.color.black
                }*/



                holder.binding.cardTypeSlot1.setCardBackgroundColor(ContextCompat.getColor(holder.binding.cardTypeSlot1.context, slot1ColorChip))
                holder.binding.textTypeSlot1.setText(PokedexToolsFunctions.translateType(item.types!!.get(1)!!.type!!.name!!))
                holder.binding.cardTypeSlot1.visibility = View.VISIBLE
            }


        }
    }

    override fun getItemCount(): Int = 151

    /*
    fun translateType(name : String) : String{

        return when(name){
            "grass" -> "Planta"
            "fire" -> "Fuego"
            "water" -> "Agua"
            "normal" -> "Normal"
            "bug" -> "Bicho"
            "ground" -> "Tierra"
            "dragon" -> "Dragon"
            "steel" -> "Acero"
            "ghost" -> "Fantasma"
            "fighting" -> "Lucha"
            "fairy" -> "Hada"
            "dark" -> "Oscuridad"
            "electric" -> "Electrico"
            "poison" -> "Veneno"
            "psychic" -> "Psiquico"
            "flying" -> "Volador"
            "ice" -> "Hielo"
            "rock" -> "Piedra"
            else -> ""
        }

    }*/
}