package com.example.memeapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memeapi.databinding.ActivityMainBinding
import com.example.memeapi.pages.CrearMemeActivity
import com.example.memeapi.pages.CrearTagActivity
import com.example.memeapi.pages.ListaMemesActivity
import com.example.memeapi.pages.ObtenerMemeIDActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnMemeID.setOnClickListener(){
            intent = Intent(this, ObtenerMemeIDActivity::class.java)
            startActivity(intent)
        }

        binding.btnListarMemes.setOnClickListener(){
            intent = Intent(this, ListaMemesActivity::class.java)
            startActivity(intent)
        }

        binding.btnCrearTag.setOnClickListener(){
            intent = Intent(this, CrearTagActivity::class.java)
            startActivity(intent)
        }

        binding.btnCrearMeme.setOnClickListener(){
            intent = Intent(this, CrearMemeActivity::class.java)
            startActivity(intent)
        }


        setContentView(binding.root)
    }
}