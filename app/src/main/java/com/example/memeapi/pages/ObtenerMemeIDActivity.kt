package com.example.memeapi.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.memeapi.databinding.ActivityObtenerMemeIdactivityBinding

class ObtenerMemeIDActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObtenerMemeIdactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObtenerMemeIdactivityBinding.inflate(layoutInflater)

        binding.btnMostrarMemeID.setOnClickListener(){
            mostarMemeID()
        }

        setContentView(binding.root)
    }

    fun mostarMemeID() {

        val id = binding.textoID.text
        if(id.equals("")){
            Toast.makeText(this, "Introduce un id de meme", Toast.LENGTH_SHORT).show()
        }else{
            intent = Intent(this, MostrarMemeActivity::class.java).apply {
                putExtra("id", id.toString())
            }
            startActivity(intent)
        }


    }
}