package com.example.pokedexfinal.utils

import com.example.pokedexfinal.R

class PokedexToolsFunctions {

    companion object{

        fun translateType(name : String) : String {
            return when (name) {
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
        }

        fun getChipTypeColor(type : String) : Int{
            return when(type){
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
            }
        }


        fun getBackgroundTypeColor(type : String) : Int{
             return when(type) {

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


            }
        }



    }
}