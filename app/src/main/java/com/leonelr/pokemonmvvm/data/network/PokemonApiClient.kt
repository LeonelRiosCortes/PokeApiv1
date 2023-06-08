package com.leonelr.pokemonmvvm.data.network

import com.leonelr.pokemonmvvm.data.model.PokemonModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiClient {
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int):Call<PokemonModel>
}