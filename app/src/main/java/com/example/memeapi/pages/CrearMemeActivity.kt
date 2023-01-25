package com.example.memeapi.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memeapi.databinding.ActivityCrearMemeBinding
import com.example.memeapi.databinding.ActivityMainBinding

class CrearMemeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearMemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearMemeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}