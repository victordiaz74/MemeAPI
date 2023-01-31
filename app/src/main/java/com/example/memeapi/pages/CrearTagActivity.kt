package com.example.memeapi.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.memeapi.MainActivity
import com.example.memeapi.api.MemeRetrofitInstance
import com.example.memeapi.databinding.ActivityCrearTagBinding
import com.example.memeapi.entidades.Tag
import com.example.memeapi.entidades.TagResponse
import retrofit2.*

class CrearTagActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearTagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearTagBinding.inflate(layoutInflater)

        binding.btCrearTag.setOnClickListener {
            crearTag()
        }

        setContentView(binding.root)
    }

    fun crearTag(){
        var nombre = binding.textoNombreTag.text.toString()
        if (!nombre.equals("")){
            MemeRetrofitInstance.api.postTag("/tag", Tag(nombre))
                .enqueue(object : Callback<TagResponse>{
                    override fun onResponse(call: Call<TagResponse>, response: Response<TagResponse>) {
                        if(response.body() != null){
                            Toast.makeText(applicationContext, "Se ha creado correctamente", Toast.LENGTH_SHORT).show()
                            intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                        }else{
                            return
                        }
                    }

                    override fun onFailure(call: Call<TagResponse>, t: Throwable) {
                        Log.d("Error crearTAG: ", t.message.toString())
                    }
                })
        }else{
            Toast.makeText(this, "No se ha podido crear correctamente", Toast.LENGTH_SHORT).show()

        }
    }

}