package com.example.memeapi.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.memeapi.api.MemeRetrofitInstance
import com.example.memeapi.databinding.ActivityCrearMemeBinding
import com.example.memeapi.entidades.Meme
import com.example.memeapi.entidades.MemeResponse
import com.example.memeapi.entidades.Tag
import com.example.memeapi.entidades.TagResponse
import retrofit2.*

class CrearMemeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearMemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearMemeBinding.inflate(layoutInflater)

        pedirTags()

        binding.btCrearMeme.setOnClickListener {
            crearMeme()
        }

        setContentView(binding.root)
    }

    fun pedirTags() {
        MemeRetrofitInstance.api.getTags("/tags")
            .enqueue(object : Callback<List<TagResponse>>{
                override fun onResponse(call: Call<List<TagResponse>>, response: Response<List<TagResponse>>) {
                    if(response.body() != null){
                        rellenarSpinner(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<List<TagResponse>>, t: Throwable) {

                }

            })
    }

    fun rellenarSpinner(body: List<TagResponse>) {
        var listaTags = ArrayList<String>()
        for (t in body){
            listaTags.add(t.texto)
        }

        binding.spinnerTags.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaTags)
    }

    fun crearMeme() {
        if(datosRellenos()) {

            MemeRetrofitInstance.api.postMeme("/meme", Meme(
                binding.textoNombreMeme.text.toString(),
                binding.txtSuperiorEdit.text.toString(),
                binding.txtInferiorEdit.text.toString(),
                binding.txtUrl.text.toString(),
                binding.spinnerTags.toString()
            )
            )
                .enqueue(object : Callback<MemeResponse> {
                    override fun onResponse(call: Call<MemeResponse>,response: Response<MemeResponse>) {
                        if (response.body() != null) {
                            intent = Intent(applicationContext, MostrarMemeActivity::class.java).apply {
                                putExtra("id", response.body()!!.idMeme.toString())
                            }

                            startActivity(intent)
                        }
                        else {
                            return
                        }
                    }

                    override fun onFailure(call: Call<MemeResponse>, t: Throwable) {
                        Log.d("TAG", t.message.toString())
                    }
                })
        }
        else {
            Toast.makeText(this, "Parece que faltan campos por rellenar", Toast.LENGTH_SHORT).show()
        }
    }

    fun datosRellenos(): Boolean {
        return  !(binding.textoNombreMeme.text.equals("") &&
                binding.txtSuperiorEdit.text.equals("") &&
                binding.txtInferiorEdit.text.equals("") &&
                binding.txtUrl.text.equals("")) &&
                binding.spinnerTags.equals("")
    }


}