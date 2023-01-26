package com.example.memeapi.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memeapi.MainActivity
import com.example.memeapi.adapter.MemeAdapter
import com.example.memeapi.api.MemeRetrofitInstance
import com.example.memeapi.databinding.ActivityListaMemesBinding
import com.example.memeapi.entidades.MemeResponse
import retrofit2.*

class ListaMemesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaMemesBinding
    private lateinit var memeAdapter: MemeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaMemesBinding.inflate(layoutInflater)

        initRecycler()

        binding.btnVolver1.setOnClickListener{
            volver()
        }

        binding.btnSiguiente.setOnClickListener{
            memeAdapter.siguientes5()
        }
        setContentView(binding.root)
    }

    fun initRecycler() {

        MemeRetrofitInstance.api.getMemes("/meme/list")
            .enqueue(object : Callback<List<MemeResponse>>{
                override fun onResponse(call: Call<List<MemeResponse>>, response: Response<List<MemeResponse>>) {
                    if(response.body() != null){
                        val rv = binding.rvMemes
                        rv.layoutManager = LinearLayoutManager(applicationContext)

                        memeAdapter = MemeAdapter (onClickListener = {id -> dameMeme(id)})
                        memeAdapter.MemeAdapter(applicationContext, response.body()!!)

                        rv.adapter = memeAdapter
                    }else {
                        Toast.makeText(applicationContext, "Error de conexion con la api", Toast.LENGTH_SHORT).show()
                        volver()
                    }
                }

                override fun onFailure(call: Call<List<MemeResponse>>, t: Throwable) {
                    Log.d("Error en el rv: ", t.message.toString())
                }
            })
    }

    fun dameMeme(id: Int){
        intent = Intent(this, MostrarMemeActivity::class.java).apply {
            putExtra("id", id.toString())
        }

        startActivity(intent)
    }

    fun volver() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}