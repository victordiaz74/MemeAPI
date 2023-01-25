package com.example.memeapi.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memeapi.databinding.ActivityCrearTagBinding

class CrearTagActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearTagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearTagBinding.inflate(layoutInflater)


        setContentView(binding.root)
    }
}