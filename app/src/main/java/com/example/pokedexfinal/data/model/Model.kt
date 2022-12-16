package com.example.pokedexfinal.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

// Pokemon General

open class PokemonList(
    @SerializedName("count") var count : Int? = null,
    @SerializedName("results") var results : RealmList<PokemonGeneral>? = null
) : RealmObject()

open class PokemonGeneral(
    @SerializedName("name") var name : String? = null,
    @SerializedName("url") var url : String? = null
) : RealmObject()

// Specific Pokemon

open class Pokemon (
    @PrimaryKey @SerializedName("id") var id : Int? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("weight") var weight : Double? = null,
    @SerializedName("height") var height : Double? = null,
    @SerializedName("abilities") var abilities : RealmList<Ability>? = null,
    @SerializedName("game_indices") var game_indices : RealmList<GameIndex>? = null,
    @SerializedName("moves") var moves : RealmList<Move>? = null,
    @SerializedName("sprites") var sprites : Sprite? = null,
    @SerializedName("stats") var stats : RealmList<BaseStat>? = null,
    @SerializedName("types") var types : RealmList<SlotType>? = null,
    var liked : Boolean? = null
        ) : RealmObject()

open class Ability(
    @PrimaryKey @SerializedName("name") var name : String? = null,
    @SerializedName("url") var url : String? = null
) : RealmObject()

open class GameIndex(
    @SerializedName("version") var version : Version? = null
) : RealmObject()

open class Version(
    @PrimaryKey @SerializedName("name") var name : String? = null,
    @SerializedName("url") var url : String? = null
) : RealmObject()

open class Move(
    @PrimaryKey @SerializedName("name") var name : String? = null,
    @SerializedName("url") var url : String? = null
) : RealmObject()

open class Sprite(
    @SerializedName("front_default") var sprite : String? = null,
    @SerializedName("other") var other : OtherSprites? = null
) : RealmObject()

open class OtherSprites(
    @SerializedName("official-artwork") var artwork : OfficialArtwork? = null
) : RealmObject()

open class OfficialArtwork(
    @SerializedName("front_default") var sprite : String? = null
) : RealmObject()

open class BaseStat(
    @SerializedName("base_stat") var base_stat : Int? = null,
    @SerializedName("stat") var stat : Stat? = null
) : RealmObject()

open class Stat(
    @PrimaryKey @SerializedName("name") var name : String? = null,
    @SerializedName("url") var url : String? = null
) : RealmObject()

open class SlotType(
    @SerializedName("slot") var slot : Int? = null,
    @SerializedName("type") var type : Type? = null
) : RealmObject()

open class Type(
    @PrimaryKey @SerializedName("name") var name : String? = null,
    @SerializedName("url") var url : String? = null
) : RealmObject()

// Evolution

open class Evolution(
    @PrimaryKey @SerializedName("id") var id : Int? = null,
    @SerializedName("chain") var chain : EvolutionChain? = null
) : RealmObject()


open class EvolutionChain(
    @SerializedName("evolves_to") var evolves_to : RealmList<EvolvesTo>? = null,
    @SerializedName("species") var specie : Specie? = null
) : RealmObject()

open class EvolutionDetails(
    @SerializedName("min_level") var min_level : Int? = null
) : RealmObject()

open class EvolvesTo(
    @SerializedName("evolution_details") var evolution_details : RealmList<EvolutionDetails>? = null,
    @SerializedName("evolves_to") var evolves_to : RealmList<EvolvesTo>? = null,
    @SerializedName("species") var specie : Specie? = null

) : RealmObject()

open class Specie(
    @PrimaryKey @SerializedName("name") var name : String? = null,
    @SerializedName("url") var url : String? = null
) : RealmObject()

// Gender
open class Gender(
    @PrimaryKey @SerializedName("id") var id : Int? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("pokemon_species_details") var species_details : RealmList<SpeciesDetails>? = null
) : RealmObject()


open class SpeciesDetails(
    @SerializedName("pokemon_species") var specie : Specie? = null,
    @SerializedName("rate") var rate : Int? = null
) : RealmObject()