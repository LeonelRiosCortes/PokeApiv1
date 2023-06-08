package com.leonelr.pokemonmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.leonelr.pokemonmvvm.databinding.ActivityMainBinding
import com.leonelr.pokemonmvvm.ui.viewmodel.PokemonViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var pokemonViewModel : PokemonViewModel //by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)


        pokemonViewModel.pokemonModel.observe(this, Observer {
            binding.nameTextView.text = "${it.name} - ${it.id}"
            binding.heightText.text = "Altura: ${it.height/10.0}m"
            binding.weightText.text = "Peso: ${it.weight/10.0}Kg"
            Glide.with(this).load(it.sprites.front_default).into(binding.imageView)

        })

        binding.btnFindPoke.setOnClickListener{
            val id = (1..1010).random()
            pokemonViewModel.getPokemon(id)

        }

    }

}