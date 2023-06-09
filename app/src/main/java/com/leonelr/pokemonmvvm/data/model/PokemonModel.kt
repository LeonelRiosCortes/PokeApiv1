package com.leonelr.pokemonmvvm.data.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(@SerializedName("id") val id: Int, @SerializedName("name")val name: String, @SerializedName("weight")val weight: Int, @SerializedName("height")val height: Int, @SerializedName("sprites")val sprites:Sprites) {


}