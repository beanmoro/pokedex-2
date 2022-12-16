package com.example.pokedexfinal.data.local

import com.example.pokedexfinal.data.model.Evolution
import com.example.pokedexfinal.data.model.EvolutionChain
import com.example.pokedexfinal.data.model.Pokemon
import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmResults

class LocalDataManager {

    companion object {


        fun savePokemonToLocalData(pokemon: Pokemon, realm : Realm){


            realm.executeTransaction {
                realm.copyToRealmOrUpdate(pokemon)
            }
        }

        fun savePokemonEvolution(evolution : Evolution, realm : Realm){
            realm.executeTransaction {
                realm.copyToRealmOrUpdate(evolution)
            }
        }

        fun loadPokemonByName(name : String, realm : Realm) : Pokemon? {
            return realm.where(Pokemon::class.java).equalTo("name", name.lowercase()).findFirst()
        }

        fun loadPokemonById(id : Int, realm : Realm) : Pokemon? {
            return realm.where(Pokemon::class.java).equalTo("id", id).findFirst()
        }

        fun loadAllPokemonFromLocalData(realm : Realm) : RealmList<Pokemon> {
            val data : RealmResults<Pokemon> = realm.where(Pokemon::class.java).findAll()
            val list : RealmList<Pokemon> = RealmList<Pokemon>()
            list.addAll(data.subList(0, data.size))

            return list
        }
    }

}