package com.example.memeapi.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memeapi.databinding.ActivityListaMemesBinding

class ListaMemesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaMemesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaMemesBinding.inflate(layoutInflater)


        setContentView(binding.root)
    }
}