package com.example.memeapi.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.example.memeapi.MainActivity
import com.example.memeapi.R
import com.example.memeapi.api.MemeRetrofitInstance
import com.example.memeapi.databinding.ActivityMostrarMemeBinding
import com.example.memeapi.databinding.ActivityObtenerMemeIdactivityBinding
import com.example.memeapi.entidades.MemeResponse
import com.squareup.picasso.Picasso
import retrofit2.*

class MostrarMemeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMostrarMemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarMemeBinding.inflate(layoutInflater)

        var id = intent.getStringExtra("id")

        mostrarMeme(id)

        binding.btnVolver.setOnClickListener{
            volver()
        }
        setContentView(binding.root)

    }

    fun mostrarMeme(id: String?) {
        MemeRetrofitInstance.api.getMeme("/meme?id=$id")
            .enqueue(object : Callback<MemeResponse>{
                override fun onResponse(call: Call<MemeResponse>, response: Response<MemeResponse>){
                    if (response.body() != null){
                        binding.txtInferior.text = response.body()!!.txtInf
                        binding.txtSuperior.text = response.body()!!.txtSup

                        var url = response.body()!!.url

                        Picasso.get()
                            .load(url)
                            .fit()
                            .centerCrop()
                            .into(binding.imgMeme)

                        binding.progressBar.isVisible = false

                    }else{
                        return
                    }
                }

                override fun onFailure(call: Call<MemeResponse>, t: Throwable) {
                    Log.d("Error getMeme:", t.message.toString())
                }

            })
    }

    fun volver() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}