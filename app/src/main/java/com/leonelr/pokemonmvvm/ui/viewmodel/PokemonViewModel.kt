package com.leonelr.pokemonmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leonelr.pokemonmvvm.core.RetrofitHelper
import com.leonelr.pokemonmvvm.data.model.PokemonModel
import com.leonelr.pokemonmvvm.data.model.PokemonProvider
import com.leonelr.pokemonmvvm.data.network.PokemonApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonViewModel : ViewModel(){

    val pokemonModel = MutableLiveData<PokemonModel>()

    fun randomPokemon(){
        val currentPokemon = PokemonProvider.random()
        pokemonModel.postValue(currentPokemon)
    }

    private val retrofit = RetrofitHelper.getRetrofit()



    fun getPokemon(id: Int) {
            val response = retrofit.create(PokemonApiClient::class.java).getPokemonInfo(id)
            response.enqueue(object : Callback<PokemonModel> {
                override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                    response.body()?.let { pokemon ->
                        pokemonModel.postValue(pokemon)
                    }
                }

                override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                    call.cancel()
                }

            })

    }


}