package com.leonelr.pokemonmvvm.data.model

import com.google.gson.annotations.SerializedName

data class Sprites (@SerializedName("front_default") val front_default: String?,@SerializedName("front_shiny") val front_shiny: String?){
}