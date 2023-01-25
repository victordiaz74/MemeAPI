package com.example.memeapi.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memeapi.databinding.ActivityObtenerMemeIdactivityBinding

class ObtenerMemeIDActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObtenerMemeIdactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObtenerMemeIdactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}