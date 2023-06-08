package com.leonelr.pokemonmvvm.data.model

class PokemonProvider {

    companion object{


        fun random():PokemonModel{
            val position = (0..4).random()
            return pokemons[position]
        }


        private val pokemons = listOf<PokemonModel>(
            PokemonModel(151,"mew", 1, 1, Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/151.png", "Imagen shiny")),
            PokemonModel(1,"bulbasaur", 1, 1, Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png", "Imagen shinybulba")),
            PokemonModel(4,"charmander", 1, 1, Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png", "Imagen shiny char")),
            PokemonModel(75,"Graveler", 10000, 3, Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/75.png", "Imagen shiny grava")),
            PokemonModel(448,"Lucario", 45, 3, Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/448.png", "Imagen shiny lucario")),
        )
    }




}